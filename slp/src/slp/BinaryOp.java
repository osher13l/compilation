package slp;

public class BinaryOp extends ASTNode {

	public final Operator op;
	
	public BinaryOp(int lineNumber, Operator op) {
		super(lineNumber);
		this.op = op;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		return visitor.visit(this, context);
	}

}
