package slp;

public class ReturnStmt extends Stmt {
	
	public final Expr returnVal;
	
	public ReturnStmt(int lineNum) {
		super(lineNum);
		this.returnVal = null;
		// TODO Auto-generated constructor stub
	}
	public ReturnStmt(int lineNum, Expr returnVal) {
		super(lineNum);
		this.returnVal = returnVal;
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
