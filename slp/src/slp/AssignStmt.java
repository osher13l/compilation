package slp;

/**
 * An AST node for assignment statements.
 */
public class AssignStmt extends Stmt {
	public final Location lhs;
	public final Expr rhs;

	public AssignStmt( int lineNumber, Location lhs, Expr rhs) {
		super(lineNumber);
		this.lhs = lhs;
		this.rhs = rhs;
	}


	/** Accepts a propagating visitor parameterized by two types.
	 * 
	 * @param <DownType> The type of the object holding the context.
	 * @param <UpType> The type of the result object.
	 * @param visitor A propagating visitor.
	 * @param context An object holding context information.
	 * @return The result of visiting this node.
	 */
	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		return visitor.visit(this, context);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}
}