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
		/*
		String res = "\t";
		return String.format(String.format("%%%ds", this.indentation), " ").replace(" ",res);*/
		
		String res = "";
		for (int i=0; i<this.indentation; i++) {
			res += "  ";
		}
		return res;
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
			System.out.println(", with initial value");
		}
		else{
			System.out.println("");
		}
		this.indentation++;
		if(stmt.type.getClass().getName()=="slp.StrType" || stmt.type.getClass().getName()=="slp.IntType"){
			System.out.print(tab()+stmt.line+": Primitive data type: ");
		}

		stmt.type.accept(this);
		if(stmt.exp != null){
			stmt.exp.accept(this);
		}
		this.indentation--;
	}
	
	//Expr...
	
	
	@Override
	//TODO
	public void visit(Call call) {

	}
	@Override
	public void visit(VirtualCall call){
		System.out.print(tab()+call.line+": Call to virtual method: "+call.title);
		this.indentation++;
		if (call.isExternal()){
			System.out.println(", in external scope");
			call.position.accept(this);
		}
		else{
			System.out.print("\n");
		}
		
		if (call.values!=null){
			for (Expr value: call.values){
				value.accept(this);
			}
		}
		this.indentation--;

	}
	@Override
	public void visit(StaticCall call){
		System.out.println(tab()+call.line+": Call to static method: "+call.title+", in class "+call.classId);
		this.indentation++;
		if (call.values!=null){
			for (Expr value: call.values){
				value.accept(this);
			}
		}
		this.indentation--;

	}
	

	@Override
	public void visit(BinaryOpExpr expr) {
		if (expr.op.isMathOp){
			System.out.println(tab()+expr.line+": Mathematical binary operation: "+expr.op.op);
		}
		else{
			System.out.println(tab()+expr.line+": Logical binary operation: "+expr.op.op);
		}
		this.indentation++;
		expr.lhs.accept(this);
		expr.rhs.accept(this);
		this.indentation--;
	}
	
	@Override
	public void visit(UnaryOpExpr expr) {
		System.out.print(tab()+expr.line + ": Unary operation: "+expr.op.op);
	}
	
	
	@Override
	public void visit(Program program) {
		for (ClassDecl cd : program.classDecls) {
			cd.accept(this);
		}
	}

	@Override
	public void visit(ClassDecl classDecl) {
		System.out.print(tab()+classDecl.line + ": Declaration of class");
		System.out.print(" " + classDecl.classId);
		if (classDecl.inheritFrom != null) {
			System.out.print(" extends " + classDecl.inheritFrom);
		}
		System.out.println();
		this.indentation++;
		classDecl.fml.accept(this);
		this.indentation--;
	}

	@Override
	public void visit(FieldsAndMethodsList fml) {
		for (FieldOrMethod fom : fml.fml) {
			fom.accept(this);
			//System.out.println();
		}
	}

	@Override
	public void visit(Field field) {
		int i=0;
		System.out.println(tab()+field.line + ": Declaration of field: "+field.idList.idList.get(i));
		this.indentation++;
		System.out.print(tab()+field.line + ": Primitive data type: ");
		field.typeOfField.accept(this);
		this.indentation--;
	}

	@Override
	public void visit(Method method) {
		System.out.print(tab()+method.line + ": Declaration of ");
		if (method.isStatic) {
			System.out.print("static method: ");
		}
		else{
			System.out.print("virtual method: ");
		}
		System.out.println(method.md.righths.identifier);
		this.indentation++;
		//System.out.print(tab()+method.line + ": Primitive data type: ");
		method.md.accept(this);
		this.indentation--;
	}

	@Override
	public void visit(MethodDeclration methodDecl) {
		if (methodDecl.lefths == null) {
			System.out.println(tab()+methodDecl.line + ": Primitive data type: void");
			this.indentation++;
			methodDecl.righths.accept(this);
		} else {
			this.indentation++;
			System.out.print(tab()+methodDecl.line+": Primitive data type: ");
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
		if (methodBody.stmtList != null) {
			methodBody.stmtList.accept(this);
		}
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
		System.out.print("1-dimensional array of ");
		arrayType.lefths.accept(this);
	}

	@Override
	public void visit(BoolType boolType) {
		System.out.println("boolean");
	}

	@Override
	public void visit(ClassType classType) {
		System.out.println(tab()+classType.line +": User-defined data type: "+classType.cId);

		
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
		
		
	}

	@Override
	public void visit(FieldOrMethod fom) {
		
		
	}

	@Override
	public void visit(This this1) {
		System.out.println(tab()+this1.line +": 'this' was refenrenced");	
		
	}

	@Override
	public void visit(NewClassInstance newClass) {
		System.out.println(tab()+newClass.line +": Instantiation of class: "+newClass.classId);
		
	}

	@Override
	public void visit(NewArray newArray) {
		System.out.println(tab()+newArray.line + ": Array allocation");
		this.indentation++;
		System.out.print(tab()+newArray.line + ": Primitive data type: ");
		newArray.type.accept(this);
		newArray.sizeOfArray.accept(this);
		this.indentation--;
		
	}

	@Override
	public void visit(Length length) {
		System.out.println(tab()+length.line + ": Reference to array length");
		this.indentation++;
		length.exp.accept(this);
		this.indentation--;
	}

	@Override
	public void visit(BinaryOp binaryOp) {
		
		
	}

	@Override
	public void visit(UnaryOp unaryOp) {
		
		
	}

	@Override
	public void visit(LocationMember locationMember) {
		System.out.println(tab()+locationMember.line + ": Reference to variable: " +locationMember.value+", in external scope");
		this.indentation++;
		locationMember.tank.accept(this);
		this.indentation--;
		
	}

	@Override
	public void visit(Location location) {
		
		
	}
	
	@Override
	public void visit(LocationAry locationAry) {
		System.out.println(tab()+locationAry.line + ": Reference to array");
		this.indentation++;
		locationAry.arrayName.accept(this);
		locationAry.Idx.accept(this);
		this.indentation--;
		
	}
	
	@Override
	public void visit(LocationVar locationVar) {
		System.out.println(tab()+locationVar.line + ": Reference to variable: "+locationVar.value);

		
	}

	@Override
	public void visit(LiteralFalse literalFalse) {
		System.out.println(tab()+literalFalse.line + ": Boolean literal: false");
		
	}

	@Override
	public void visit(LiteralInteger literalInteger) {
		System.out.println(tab()+literalInteger.line + ": Integer literal: "+literalInteger.value);
		
	}

	@Override
	public void visit(LiteralNull literalNull) {
		System.out.println(tab()+literalNull.line + ": literal: null");
		
	}

	@Override
	public void visit(LiteralString literalStr) {
		System.out.println(tab()+literalStr.line + ": String literal: "+literalStr.value);
		
	}

	@Override
	public void visit(LiteralTrue literalTrue) {
		System.out.println(tab()+literalTrue.line + ": Boolean literal: true");
		
	}

	@Override
	public void visit(BlockOfStmts blockOfStmts) {
		System.out.println(tab()+blockOfStmts.line + ": Block of statements");
		this.indentation++;
		blockOfStmts.statements.accept(this);
		this.indentation--;
		
	}









}