package kr.or.ddit.role.model;

public class RoleVo {
	private	String	role;
	private	String	resourceId;
	private	String	resourceName;
	private	String	resourcePattern;
	private	String	resourceType;
	private	int		sortOrder;
	
	public RoleVo() {
		
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourcePattern() {
		return resourcePattern;
	}
	public void setResourcePattern(String resourcePattern) {
		this.resourcePattern = resourcePattern;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public String toString() {
		return "RoleVo [role=" + role + ", resourceId=" + resourceId + ", resourceName=" + resourceName
				+ ", resourcePattern=" + resourcePattern + ", resourceType=" + resourceType + ", sortOrder=" + sortOrder
				+ "]";
	}
}
