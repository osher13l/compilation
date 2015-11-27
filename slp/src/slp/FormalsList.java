package slp;

import java.util.ArrayList;
import java.util.List;

public class FormalsList extends ASTNode {
	
	public final List<Type> types = new ArrayList<>();
	
	public final List<String> identifiers = new ArrayList<>();

	public FormalsList(int line, Type type, String id) {
		super(line);
		this.types.add(type);
		this.identifiers.add(id);
	}
	
	public void addFormal(Type type, String id) {
		this.types.add(type);
		this.identifiers.add(id);
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
