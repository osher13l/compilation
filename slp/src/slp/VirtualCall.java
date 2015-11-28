package slp;

import java.util.List;

public class VirtualCall extends Call {
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
	

	public VirtualCall(int line, String Id, List<Expr> values) {
		super(line, Id, values);
	}
	
	public VirtualCall(int line, String name) {
		super(line, name, null);
	}


	public VirtualCall(int IdxLine, Expr location, String Id,
			List<Expr> values) {
		this(IdxLine, Id, values);
		this.position = location;
	}
	
	public VirtualCall(int IdxLine, Expr location, String Id) {
		this(IdxLine, Id, null);
		this.position = location;
	}

	public boolean isExternal() {
		return (position != null);
	}

	public Expr getLocation() {
		return position;
	}
}
