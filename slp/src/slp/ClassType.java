package slp;

public class ClassType extends Type {

	public final String cId;
	
	public ClassType(int line,String cid) {
		super(line);
		this.cId = cid;
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
