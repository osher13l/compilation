package slp;

public class MethodSignature extends ASTNode {
	
	public final FormalsList params;
	public final String identifier;
	public final MethodBody methodBody;
	
	public MethodSignature(int line, String id, MethodBody mb) {
		super(line);
		this.methodBody = mb;
		this.params = null;
		this.identifier = id;
	}
	
	public MethodSignature(int line, String id, MethodBody mb, FormalsList formals) {
		super(line);
		this.identifier = id;
		this.methodBody = mb;
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
