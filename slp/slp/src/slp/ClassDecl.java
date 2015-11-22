package slp;

public class ClassDecl extends ASTNode{

	public final String classId;
	
	public final FieldsAndMethodsList fml;
	
	public final String inheritFrom;
	
	public ClassDecl(String cid) {
		this.classId = cid;
		this.fml = null;
		this.inheritFrom = null;
	}
	
	public ClassDecl(String cid, FieldsAndMethodsList fml) {
		this.classId = cid;
		this.fml = fml;
		this.inheritFrom = null;
	}
	
	public ClassDecl(String cid, String ifid) {
		this.classId = cid;
		this.fml = null;
		this.inheritFrom = ifid;
	}
	
	public ClassDecl(String cid, FieldsAndMethodsList fml, String ifid) {
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
