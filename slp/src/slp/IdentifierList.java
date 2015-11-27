package slp;

import java.util.ArrayList;
import java.util.List;

public class IdentifierList extends ASTNode {

	public final List<String> idList = new ArrayList<>();
	
	public IdentifierList(int lineNumber,String id) {
		super(lineNumber);
		idList.add(id);
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
