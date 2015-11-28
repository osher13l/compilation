package slp;

public class LiteralString extends Literal {

	public final String value;
	
	public LiteralString(int lineIdx, String value) {
		super(lineIdx);
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
