package slp;

public class LiteralInteger extends Literal {

	public final int value;
	
	public LiteralInteger(int lineIdx, int value) {
		super(lineIdx);
		this.value = value;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <DownType, UpType> UpType accept(PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		// TODO Auto-generated method stub
		return null;
	}

}
