package slp;

public class MethodBody extends ASTNode {
	
	public final StmtList stmtList;

	public MethodBody(int line) {
		super(line);
		this.stmtList = null;
	}
	
	public MethodBody(int line, StmtList sl) {
		super(line);
		this.stmtList = sl;
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
