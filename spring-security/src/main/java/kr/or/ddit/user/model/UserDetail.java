package kr.or.ddit.user.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetail extends User{
	
	private String orgCd;
	
	public UserDetail(String username, String password, String orgCd, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
		this.orgCd = orgCd;
	}

	public String getOrgCd() {
		return orgCd;
	}

	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}
	
	public String getTest() {
		return "test1234";
	}

	
}
