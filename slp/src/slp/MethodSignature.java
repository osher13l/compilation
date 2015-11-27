package slp;

public class MethodSignature extends ASTNode {
	
	public final Formals params;
	public final String identifier;
	public final MethodBody righths;
	
	public MethodSign(int line, String id, MethodBody mb) {
		super(line);
		this.righths = mb;
		this.params = null;
		this.identifier = id;
	}
	
	public MethodSign(int line, String id, MethodBody mb, Formals formals) {
		super(line);
		this.identifier = id;
		this.rhs = mb;
		this.params = formals;
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
