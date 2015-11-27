package slp;

public class MethodDeclration extends ASTNode {
	
	
	public final MethodSignature righths;
	public final Type lefths;

	public MethodDeclration(int line, MethodSignature m,Type t) {
		super(line);
		this.righths = m;
		this.lefths = t;
	}
	
	public MethodDeclration(int line, MethodSignature m) {
		super(line);
		this.righths = m;
		this.lefths = null;
	}
	

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);;

	}

	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		// TODO Auto-generated method stub
		return null;
	}

}
