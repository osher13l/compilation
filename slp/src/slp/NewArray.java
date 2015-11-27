package slp;

public class NewArray extends Expr {
	
	public final Type type;
	public final Expr sizeOfArray;
	
	public NewArray(int lineNumber, Type type, Expr size) {
		super(lineNumber);
		this.type = type;
		this.sizeOfArray = size;
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
