package slp;

import java.util.List;

public abstract class VirtualCall extends Call {
	private Expr position = null;
	

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}


	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		return visitor.visit(this, context);
	}
	

	public VirtualCall(int line, String name, List<Expr> arguments) {
		super(line, name, arguments);
	}


	public VirtualCall(int IdxLine, Expr location, String Id,
			List<Expr> values) {
		this(IdxLine, Id, values);
		this.position = location;
	}

	public boolean isExternal() {
		return (position != null);
	}

	public Expr getLocation() {
		return position;
	}
}
