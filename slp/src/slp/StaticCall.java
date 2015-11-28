package slp;

import java.util.List;

public class StaticCall extends Call {
	public String classId;
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		return visitor.visit(this, context);
	}

	public StaticCall(int line, String cid, String id,
			List<Expr> values) {
		super(line, id, values);
		this.classId = cid;
	}
	public StaticCall(int line, String cid, String id) {
		super(line, id, null);
		this.classId = cid;
	}

	public String getClassTitle() {
		return classId;
	}
}
