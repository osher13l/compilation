package slp;

public class ContinueStmt extends Stmt {


	
	
	public ContinueStmt(int lineNum) {
		super(lineNum);

		
		
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		// TODO Auto-generated method stub
		return null;
	}

}
