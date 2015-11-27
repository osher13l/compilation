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
	public void visit(Literal expr);
	public void visit(ExpressionBlock expr);
	public void visit(CallStmt stmt);
	public void visit(Return stmt);
	public void visit(If stmt);
	public void visit(While stmt);
	public void visit(Break stmt);
	public void visit(Continue stmt);
	public void visit(StmtsBlock stmts);
	public void visit(LocalVariable stmt);
	public void visit(Call expr);
	public void visit(This expr);
	public void visit(NewClass expr);
	public void visit(NewArray expr);
	public void visit(Length expr);
	public void visit(BinaryOp binaryOp);
	public void visit(UnaryOp unaryOp);
	public void visit(LocationId locId);
	public void visit(LocationMember locMember);
	public void visit(LocationArray locArray);
	public void visit(NumberExpr number);
	public void visit(LiteralInt literal);
	public void visit(LiteralStr literal);
	public void visit(LiteralTrue literal);
	public void visit(LiteralFalse literal);
	public void visit(LiteralNull literal);
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