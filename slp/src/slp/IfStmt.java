package slp;

public class IfStmt extends Stmt {
	public final Stmt statement;
	public final Expr exp;
	public final Stmt else_statement;
	
	public IfStmt(int lineNum, Expr e, Stmt s) {
		super(lineNum);
		this.exp = e;
		this.statement = s;
		this.else_statement = null;
		// TODO Auto-generated constructor stub
	}
	
	public IfStmt(int lineNum, Expr e, Stmt s, Stmt else_s) {
		super(lineNum);
		this.exp = e;
		this.statement = s;
		this.else_statement = else_s;
		// TODO Auto-generated constructor stub
	}

	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

}
