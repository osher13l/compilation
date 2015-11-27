package slp;

public class This extends Expr {

	public This(int lineNumber) {
		super(lineNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		return visitor.visit(this, context);
	}

}
