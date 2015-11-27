package slp;

public class VarDeclStmt extends Stmt {
	
	public final Type type;
	public final String id;
	public final Expr exp;
	
	public VarDeclStmt(int lineNum, Type t, String id, Expr e) {
		super(lineNum);
		this.type = t;
		this.id = id;
		this.exp = e;
		// TODO Auto-generated constructor stub
	}
	public VarDeclStmt(int lineNum, Type t, String id) {
		super(lineNum);
		this.type = t;
		this.id = id;
		this.exp = null;
		// TODO Auto-generated constructor stub
	}
	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		// TODO Auto-generated method stub
		return null;
	}

}
