package slp;

import java.io.IOException;

/** Evaluates straight line programs.
 */
public class SLPEvaluator implements PropagatingVisitor<Environment, Integer> {
	protected ASTNode root;

	/** Constructs an SLP interpreter for the given AST.
	 * 
	 * @param root An SLP AST node.
	 */
	public SLPEvaluator(ASTNode root) {
		this.root = root;
	}
	
	/** Interprets the AST passed to the constructor.
	 */
	public void evaluate() {
		Environment env = new Environment();
		root.accept(this, env);
	}
	
	public Integer visit(StmtList stmts, Environment env) {
		for (Stmt st : stmts.statements) {
			st.accept(this, env);
		}
		return null;
	}

	public Integer visit(Stmt stmt, Environment env) {
		throw new UnsupportedOperationException("Unexpected visit of Stmt!");
	}

	public Integer visit(AssignStmt stmt, Environment env) {
		Expr rhs = stmt.rhs;
		Integer expressionValue = rhs.accept(this, env);
		Location var = stmt.lhs;
		env.update(var, expressionValue);
		return null;
	}

	public Integer visit(Expr expr, Environment env) {
		throw new UnsupportedOperationException("Unexpected visit of Expr!");
	}

	public Integer visit(Location expr, Environment env) {
		return env.get(expr);
	}

	public Integer visit(NumberExpr expr, Environment env) {
		return new Integer(expr.value);		
		// return expr.value; also works in Java 1.5 because of auto-boxing
	}

	public Integer visit(UnaryOpExpr expr, Environment env) {
		UnaryOp op = expr.op;
		if (op.op == Operator.MINUS) {			
			Integer value = expr.operand.accept(this, env);
			return new Integer(- value.intValue());
		} else if (op.op == Operator.LNEG) {
			if (expr.operand.accept(this, env) == 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			throw new RuntimeException("Op is not compatible for unary");
		}
	}

	public Integer visit(BinaryOpExpr expr, Environment env) {
		Integer lhsValue = expr.lhs.accept(this, env);
		int lhsInt = lhsValue.intValue();
		Integer rhsValue = expr.rhs.accept(this, env);
		int rhsInt = rhsValue.intValue();
		int result;
		switch (expr.op.op) {
		case DIVIDE:
			if (rhsInt == 0)
				throw new RuntimeException("Attempt to divide by zero: " + expr);
			result = lhsInt / rhsInt;
			break;
		case MINUS:
			result = lhsInt - rhsInt;
			break;
		case MULTIPLY:
			result = lhsInt * rhsInt;
			break;
		case PLUS:
			result = lhsInt + rhsInt;
			break;
		case LT:
			result = lhsInt < rhsInt ? 1 : 0;
			break;
		case GT:
			result = lhsInt > rhsInt ? 1 : 0;
			break;
		case LTE:
			result = lhsInt <= rhsInt ? 1 : 0;
			break;
		case GTE:
			result = lhsInt >= rhsInt ? 1 : 0;
			break;
		case LAND:
			result = (lhsInt!=0 && rhsInt!=0) ? 1 : 0;
			break;
		case LOR:
			result = (lhsInt!=0 || rhsInt!=0) ? 1 : 0;
			break;
		default:
			throw new RuntimeException("Encountered unexpected operator type: " + expr.op);
		}
		return new Integer(result);
	}
}