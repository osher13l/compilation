package slp;

public class LocationAry extends Location {

	public final Expr container;
	
	public final Expr Idx;
	
	public LocationAry(int lineNum, Expr tank, Expr Idx) {
		super(lineNum);
		this.container = tank;
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
