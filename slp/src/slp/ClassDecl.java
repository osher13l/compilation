package slp;

public class ClassDecl extends ASTNode{

	public final String classId;
	
	public final FieldsAndMethodsList fml;
	
	public final String inheritFrom;
	
	public ClassDecl(int lineNumber, String cid) {
		super(lineNumber);
		this.classId = cid;
		this.fml = null;
		this.inheritFrom = null;
	}
	
	public ClassDecl(int lineNumber,String cid, FieldsAndMethodsList fml) {
		super(lineNumber);
		this.classId = cid;
		this.fml = fml;
		this.inheritFrom = null;
	}
	
	public ClassDecl(int lineNumber,String cid, String ifid) {
		super(lineNumber);
		this.classId = cid;
		this.fml = null;
		this.inheritFrom = ifid;
	}
	
	public ClassDecl(int lineNumber,String cid, FieldsAndMethodsList fml, String ifid) {
		super(lineNumber);
		this.classId = cid;
		this.fml = fml;
		this.inheritFrom = ifid;
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
