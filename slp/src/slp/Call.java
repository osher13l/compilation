package slp;
import java.util.List;
public abstract class Call extends Expr {
	private String title;

	private List<Expr> values;
	public Call(int line, String title, List<Expr> values) {
		super(line);
		this.title = title;
		this.values = values;
	}

	public List<Expr> getValues() {
		return values;
	}

	

	/** Accepts a visitor object as part of the visitor pattern.
	 * @param visitor A visitor.
	 */
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		return visitor.visit(this, context);
	}
	
	public String toString() {
		return title + values.toString();
	}	
}
