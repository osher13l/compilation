package slp;

/** Pretty-prints an SLP AST.
 */
public class PrettyPrinter implements Visitor {
	protected final ASTNode root;
	private int indentation = 0;

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
	
	private String tab(){
		String res = "\t";
		return String.format(String.format("%%%ds", this.indentation), " ").replace(" ",res);
	}
	//Stmt...
	
	@Override
	public void visit(StmtList stmts) {
		for (Stmt s : stmts.statements) {
			s.accept(this);
		}
	}
	
	@Override
	public void visit(Stmt stmt) {
		throw new UnsupportedOperationException("Unexpected visit of Stmt abstract class");
	}
	
	@Override
	public void visit(AssignStmt stmt) {
		System.out.println(tab()+stmt.line+": Assignment statement");
		this.indentation++;
		stmt.lhs.accept(this);
		stmt.rhs.accept(this);
		this.indentation--;
	}
	
	@Override
	public void visit(CallStmt stmt) {
		System.out.println(tab()+stmt.line+": Method call statement");
		this.indentation++;
		stmt.call.accept(this);
		this.indentation--;
	}
	
	@Override
	public void visit(ReturnStmt stmt) {
		System.out.print(tab()+stmt.line+": Return statement");
		if(stmt.returnVal != null){
			System.out.println(", with return value");
			this.indentation++;
			stmt.returnVal.accept(this);
			this.indentation--;
		}
	}
	
	@Override
	public void visit(IfStmt stmt) {
		System.out.println(tab()+stmt.line+": If statement");
		this.indentation++;
		stmt.exp.accept(this);
		stmt.statement.accept(this);
		this.indentation--;
		if(stmt.else_statement!=null){
			System.out.println(tab()+stmt.else_statement.line+": Else statement");
			this.indentation++;
			stmt.else_statement.accept(this);
			this.indentation--;
		}		
	}
	
	@Override
	public void visit(WhileStmt stmt) {
		System.out.println(tab()+stmt.line+": While statement");
		this.indentation++;
		stmt.exp.accept(this);
		stmt.statement.accept(this);
		this.indentation--;
	}
	
	@Override
	public void visit(BreakStmt stmt) {
		System.out.println(tab()+stmt.line+": Break statement");
	}
	
	@Override
	public void visit(ContinueStmt stmt) {
		System.out.println(tab()+stmt.line+": Continue statement");
	}
		
	
	@Override
	public void visit(VarDeclStmt stmt) {
		System.out.print(tab()+stmt.line+": Declaration of local variable: "+stmt.id);
		if(stmt.exp != null){
			System.out.print(", with initial value");
		}
		this.indentation++;
		stmt.type.accept(this);
		if(stmt.exp != null){
			stmt.exp.accept(this);
		}
		this.indentation--;
	}
	
	//Expr...
	
	
	@Override
	//TODO
	public void visit(Call expr) {
	}
	
	

	@Override
	//TODO
	public void visit(BinaryOpExpr expr) {
		expr.lhs.accept(this);
		System.out.print(expr.op);
		expr.rhs.accept(this);
	}
	
	@Override
	//TODO
	public void visit(UnaryOpExpr expr) {
		System.out.print(expr.op);
		expr.operand.accept(this);
	}
	
	
	@Override
	public void visit(Program program) {
		for (ClassDecl cd : program.classDecls) {
			cd.accept(this);
		}
	}

	@Override
	public void visit(ClassDecl classDecl) {
		System.out.print(tab()+classDecl.line + ": Declration of class");
		System.out.print(" " + classDecl.classId);
		if (classDecl.inheritFrom != null) {
			System.out.print(" extends " + classDecl.inheritFrom);
		}
		this.indentation++;
		classDecl.fml.accept(this);
		this.indentation--;
	}

	@Override
	public void visit(FieldsAndMethodsList fml) {
		for (FieldOrMethod fom : fml.fml) {
			fom.accept(this);
			System.out.println();
		}
	}

	@Override
	//TODO
	public void visit(Field field) {
		field.typeOfField.accept(this);
		System.out.print(" ");
		field.idList.accept(this);
		System.out.print(";");
	}

	@Override
	public void visit(Method method) {
		System.out.print(tab()+method.line + ": Declration of ");
		if (method.isStatic) {
			System.out.print("static method: ");
		}
		else{
			System.out.print("virtual method: ");
		}
		System.out.println(method.md.righths.identifier);
		this.indentation++;
		method.md.accept(this);
		this.indentation--;
	}

	@Override
	public void visit(MethodDeclration methodDecl) {
		if (methodDecl.lefths == null) {
			System.out.print(tab()+methodDecl.line + ": Primitive data type: void");
			this.indentation++;
			methodDecl.righths.accept(this);
		} else {
			this.indentation++;
			methodDecl.lefths.accept(this);
			methodDecl.righths.accept(this);
		}
		this.indentation--;
	}

	@Override
	public void visit(MethodSignature methodSign) {
		if (methodSign.params != null) {
			methodSign.params.accept(this);
		}
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
		for (int i = 0; i < formals.identifiers.size(); i++) {
			System.out.println(tab()+formals.line +": Parameter: "+formals.identifiers.get(i));
			this.indentation++;
			System.out.print(tab()+formals.line +": Primitive data type: ");
			formals.types.get(i).accept(this);
			this.indentation--;
		}
	}

	@Override
	public void visit(ArrayType arrayType) {
		System.out.print(tab()+arrayType.line +"1-dimensional array of ");
		arrayType.lefths.accept(this);
	}
	//TODO
	@Override
	public void visit(BoolType boolType) {
		System.out.println("boolean");
	}
	//TODO
	@Override
	public void visit(ClassType classType) {
		System.out.print(classType.cId);
	}

	@Override
	public void visit(StrType strType) {
		System.out.println("string");
	}

	@Override
	public void visit(IntType intType) {
		System.out.println("int");
	}

//continue from here
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

	@Override
	public void visit(UnaryOp unaryOp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LocationMember locationMember) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LiteralFalse literalFalse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LiteralInteger literalInteger) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LiteralNull literalNull) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LiteralString literalStr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LiteralTrue literalTrue) {
		// TODO Auto-generated method stub
		
	}





}