package slp;

public class LocationVar extends Location {

	public final String value;
	
	public LocationVar(int lineNum, String value) {
		super(lineNum);
		this.value = value;
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
