package slp;

import java.util.ArrayList;
import java.util.List;

public class FieldsAndMethodsList extends ASTNode{
	
	public final List<FieldOrMethod> fml = new ArrayList<>();
	
	public FieldsAndMethodsList(FieldOrMethod fom){
		this.fml.add(fom);
	}
	
	public void addFieldOrMethod(FieldOrMethod fom){
		this.fml.add(fom);
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
