package slp;

import java.util.List;

public abstract class StaticCall extends Call {
	private String title;
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		return visitor.visit(this, context);
	}

	public StaticCall(int line, String title, String id,
			List<Expr> values) {
		super(line, title, values);
		this.title = title;
	}

	public String getClassTitle() {
		return title;
	}
}
