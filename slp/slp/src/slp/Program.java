package slp;

import java.util.ArrayList;
import java.util.List;

public class Program extends ASTNode {

	public final List<ClassDecl> classDecls = new ArrayList<>();
	
	public Program(ClassDecl cd) {
		classDecls.add(cd);
	}
	
	public void addClassDecl(ClassDecl cd) {
		classDecls.add(cd);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <DownType, UpType> UpType accept(PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
