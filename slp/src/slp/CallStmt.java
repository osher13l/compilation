package slp;

public class CallStmt extends Stmt {
	
	public final Call call;
	
	public CallStmt(int lineNum, Call c) {
		super(lineNum);
		this.call = c;
		// TODO Auto-generated constructor stub
	}

	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
