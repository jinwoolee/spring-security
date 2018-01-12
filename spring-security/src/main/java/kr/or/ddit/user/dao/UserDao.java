package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserDetail;
import kr.or.ddit.user.model.UserRoles;

public interface UserDao {
	
	List<UserDetail> usersByUsername(String username);
	
	UserRoles authoritiesByUsername(String username);
}
