package slp;

public class ArrayType extends Type {

	public final Type lefths;
	public ArrayType(int line,Type type) {
		super(line);
		this.lefths = type;
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
