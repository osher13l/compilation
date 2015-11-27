package slp;

/** An interface for AST visitors.
 */
public interface Visitor {
	public void visit(Program program);
	public void visit(ClassDecl classDecl);
	public void visit(FieldsAndMethodsList fml);
	public void visit(FieldOrMethod fom);
	public void visit(Field field);
	public void visit(Method method);


	
	
	public void visit(StmtList stmts);
	public void visit(Stmt stmt);

	public void visit(AssignStmt stmt);

	public void visit(UnaryOpExpr expr);
	public void visit(BinaryOpExpr expr);
	public void visit(CallStmt stmt);
	public void visit(ReturnStmt stmt);
	public void visit(IfStmt stmt);
	public void visit(WhileStmt stmt);
	public void visit(BreakStmt stmt);
	public void visit(ContinueStmt stmt);
	public void visit(VarDeclStmt stmt);
	public void visit(Call expr);
	public void visit(NumberExpr number);
	public void visit(ArrayType arrayType);
	public void visit(BoolType boolType);
	public void visit(StrType strType);
	public void visit(IntType intType);
	public void visit(IdentifierList identifierList);
	public void visit(MethodDeclration methodDeclration);
	public void visit(MethodSignature methodSignature);
	public void visit(MethodBody methodBody);
	public void visit(FormalsList formalsList);
	public void visit(ClassType classType);

}