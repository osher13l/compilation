package slp;

public class LocationAry extends Location {

	public final Expr arrayName;
	
	public final Expr Idx;
	
	public LocationAry(int lineNum, Expr arrayName, Expr Idx) {
		super(lineNum);
		this.arrayName = arrayName;
		this.Idx = Idx;
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
