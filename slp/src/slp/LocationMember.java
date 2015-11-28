package slp;

public class LocationMember extends Location {

	
	public final String value;	
	public final Expr tank;
	
	public LocationMember(int lineNum, String value, Expr tank) {
		super(lineNum);
		this.value = value;
		this.tank = tank;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <DownType, UpType> UpType accept(PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		return null;
	}
	
}
