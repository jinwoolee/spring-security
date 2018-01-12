package kr.or.ddit.user.model;

import java.util.List;

public class UserRoles {
	private	String			username;
	private	List<String>	roles;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UserRoles [username=" + username + ", roles=" + roles + "]";
	}
	
}
