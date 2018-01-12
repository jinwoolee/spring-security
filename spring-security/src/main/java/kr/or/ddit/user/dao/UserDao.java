package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.model.UserRoles;

public interface UserDao {
	
	UserVo usersByUsername(String username);
	
	UserRoles authoritiesByUsername(String username);
}
