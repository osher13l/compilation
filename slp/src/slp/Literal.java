package slp;

public class Literal extends Expr {

	public Literal(int lineNumber) {
		super(lineNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		// TODO Auto-generated method stub
		return null;
	}

}