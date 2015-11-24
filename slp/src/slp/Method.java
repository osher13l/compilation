package slp;

public class Method extends FieldOrMethod {

	public final boolean isStatic;
	
	public final MethodDecl md;
	
	public Method(MethodDecl md, boolean isStatic) {
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
