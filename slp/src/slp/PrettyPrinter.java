package slp;

/** Pretty-prints an SLP AST.
 */
public class PrettyPrinter implements Visitor {
	protected final ASTNode root;

	/** Constructs a printing visitor from an AST.
	 * 
	 * @param root The root of the AST.
	 */
	public PrettyPrinter(ASTNode root) {
		this.root = root;
	}

	/** Prints the AST with the given root.
	 */
	public void print() {
		root.accept(this);
	}
	//Stmt...
	
	@Override
	public void visit(StmtList stmts) {
		for (Stmt s : stmts.statements) {
			s.accept(this);
			//System.out.println();
		}
	}
	
	@Override
	public void visit(Stmt stmt) {
		throw new UnsupportedOperationException("Unexpected visit of Stmt abstract class");
	}
	
	@Override
	public void visit(AssignStmt stmt) {
		stmt.lhs.accept(this);
		System.out.print("=");
		stmt.rhs.accept(this);
		System.out.println(";");
	}
	
	@Override
	public void visit(CallStmt stmt) {
		stmt.call.accept(this);
		System.out.println(";");
	}
	
	@Override
	public void visit(ReturnStmt stmt) {
		System.out.print("RETURN");
		if(stmt.returnVal != null){
			stmt.returnVal.accept(this);
		}		
		System.out.println(";");
	}
	
	@Override
	public void visit(IfStmt stmt) {
		System.out.print("IF(");
		stmt.exp.accept(this);
		System.out.print(")");
		stmt.statement.accept(this);
		if(stmt.else_statement!=null){
			System.out.println("ELSE");
			stmt.else_statement.accept(this);
		}		
	}
	
	@Override
	public void visit(WhileStmt stmt) {
		System.out.print("WHILE(");
		stmt.exp.accept(this);
		System.out.print(")");
		stmt.statement.accept(this);
		//System.out.println("");
	}
	
	@Override
	public void visit(BreakStmt stmt) {
		System.out.println("BREAK;");
	}
	
	@Override
	public void visit(ContinueStmt stmt) {
		System.out.println("CONTINUE;");
	}
		
	
	@Override
	public void visit(VarDeclStmt stmt) {
		//System.out.print("IF(");
		stmt.type.accept(this);
		System.out.print(" " + stmt.id);		
		if(stmt.exp != null){
			System.out.print("=");
			stmt.exp.accept(this);
		}		
		System.out.println(";");
	}
	
	//Expr...
	
	
	@Override
	public void visit(Call expr) {
	}
	
	

	@Override
	public void visit(BinaryOpExpr expr) {
		expr.lhs.accept(this);
		System.out.print(expr.op);
		expr.rhs.accept(this);
	}
	
	@Override
	public void visit(UnaryOpExpr expr) {
		System.out.print(expr.op);
		expr.operand.accept(this);
	}
	
	
	@Override
	public void visit(Program program) {
		for (ClassDecl cd : program.classDecls) {
			cd.accept(this);
			System.out.println();
		}
	}

	@Override
	public void visit(ClassDecl classDecl) {
		System.out.print(classDecl.line + ": class");
		System.out.print(" " + classDecl.classId);
		if (classDecl.inheritFrom != null) {
			System.out.print(" extends " + classDecl.inheritFrom);
		}
		System.out.println(" {");
		classDecl.fml.accept(this);
		System.out.println("}");
	}

	@Override
	public void visit(FieldsAndMethodsList fml) {
		for (FieldOrMethod fom : fml.fml) {
			fom.accept(this);
			System.out.println();
		}
	}

	@Override
	public void visit(Field field) {
		field.typeOfField.accept(this);
		System.out.print(" ");
		field.idList.accept(this);
		System.out.print(";");
	}

	@Override
	public void visit(Method method) {
		if (method.isStatic) {
			System.out.print("static ");
		}
		method.md.accept(this);
	}

	@Override
	public void visit(MethodDeclration methodDecl) {
		if (methodDecl.lefths == null) {
			System.out.print("void");
		} else {
			methodDecl.lefths.accept(this);
		}
		System.out.print(" ");
		methodDecl.righths.accept(this);
		System.out.println(" ");
	}

	@Override
	public void visit(MethodSignature methodSign) {
		System.out.print(methodSign.identifier);
		System.out.print("(");
		if (methodSign.params != null) {
			methodSign.params.accept(this);
		}
		System.out.print(")");
		methodSign.methodBody.accept(this);
	}

	@Override
	public void visit(MethodBody methodBody) {
		System.out.println("{");
		if (methodBody.stmtList != null) {
			methodBody.stmtList.accept(this);
		}
		System.out.println("}");
	}

	@Override
	public void visit(IdentifierList idList) {
		System.out.print(String.join(", ", idList.idList));
	}

	@Override
	public void visit(FormalsList formals) {
		String delimitor = "";
		for (int i = 0; i < formals.identifiers.size(); i++) {
			System.out.print(delimitor);
			formals.types.get(i).accept(this);
			System.out.print(" " + formals.identifiers.get(i));
			delimitor = ", ";
		}
	}

	@Override
	public void visit(ArrayType arrayType) {
		arrayType.lefths.accept(this);
		System.out.print("[]");
	}

	@Override
	public void visit(BoolType boolType) {
		System.out.print("boolean");
	}

	@Override
	public void visit(ClassType classType) {
		System.out.print(classType.cId);
	}

	@Override
	public void visit(StrType strType) {
		System.out.print("string");
	}

	@Override
	public void visit(IntType intType) {
		System.out.print("int");
	}


	@Override
	public void visit(NumberExpr number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FieldOrMethod fom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(This this1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NewClassInstance newClass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NewArray newArray) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Length length) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BinaryOp binaryOp) {
		// TODO Auto-generated method stub
		
	}



}