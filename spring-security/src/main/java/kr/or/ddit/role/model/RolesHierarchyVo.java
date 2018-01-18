package kr.or.ddit.role.model;

public class RolesHierarchyVo {
	
	private String parent_role;		//상위권한
	private String child_role;		//하위권한
	
	public RolesHierarchyVo() {
		
	}
	public String getParent_role() {
		return parent_role;
	}
	public void setParent_role(String parent_role) {
		this.parent_role = parent_role;
	}
	public String getChild_role() {
		return child_role;
	}
	public void setChild_role(String child_role) {
		this.child_role = child_role;
	}
	
	@Override
	public String toString() {
		return "RolesHierarchyVo [parent_role=" + parent_role + ", child_role=" + child_role + "]";
	}
}
