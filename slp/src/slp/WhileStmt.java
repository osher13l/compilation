package slp;

public class WhileStmt extends Stmt {

	public final Expr exp;
	public final Stmt statement;
	
	
	public WhileStmt(int lineNum, Expr e, Stmt s) {
		super(lineNum);
		this.exp = e;
		this.statement = s;
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		// TODO Auto-generated method stub
		return null;
	}

}
