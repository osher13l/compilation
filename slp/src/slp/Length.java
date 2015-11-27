package slp;

public class Length extends Expr {
	public final Expr exp;
	
	public Length(int lineNumber, Expr e) {
		super(lineNumber);
		this.exp = e;
		
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
