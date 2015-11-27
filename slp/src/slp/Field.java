package slp;

public class Field extends FieldOrMethod {

	public final Type typeOfField;
	
	public final IdentifierList idList;
	
	public Field(int line, Type type, IdentifierList idlist) {
		super(line);
		this.idList=idlist;
		this.typeOfField = type;
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
