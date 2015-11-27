package slp;

public class NewClassInstance extends Expr {

	public final String classId; 
	
	public NewClassInstance(int lineNumber, String cid) {
		super(lineNumber);
		this.classId = cid;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		// TODO Auto-generated method stub
		return null;
	}

}
