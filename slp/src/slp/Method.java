package slp;

public class Method extends FieldOrMethod {

	public final boolean isStatic;
	
	public final MethodDeclration md;
	
	public Method(int line,MethodDeclration md, boolean isStatic) {
		super(line);
		this.md = md;
		this.isStatic = isStatic;
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
