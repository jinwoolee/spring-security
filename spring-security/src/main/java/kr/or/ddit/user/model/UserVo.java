package kr.or.ddit.user.model;

public class UserVo{
		
	private	String	username;
	private	String	password;
	private	String	enabled;
	private	String	orgCd;
	
	public UserVo() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	public String getOrgCd() {
		return orgCd;
	}

	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}

	@Override
	public String toString() {
		return "UserVo [username=" + username + ", password=" + password + ", enabled=" + enabled + ", orgCd=" + orgCd
				+ "]";
	}

	public void setupUserVo(UserDetail userDetail) {
		this.username	=	userDetail.getUsername();
		this.password	=	userDetail.getPassword();
		this.enabled	=	userDetail.isEnabled() == true ? "1" : "0";
		this.orgCd		=	userDetail.getOrgCd();
	}
}
