package kr.or.ddit.user.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.model.UserDetail;
import kr.or.ddit.user.model.UserRoles;

@Component("userService")
public class UserService implements UserDetailsService{

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVo user = userDao.usersByUsername(username);
		UserRoles userRoles = userDao.authoritiesByUsername(username);
		
		Set<GrantedAuthority> rolesSet = new HashSet<GrantedAuthority>();
		for(String role : userRoles.getRoles()) 
			rolesSet.add(new SimpleGrantedAuthority(role));
		
		UserDetail userDetail = new UserDetail(user.getUsername(), user.getPassword(), user.getOrgCd(), rolesSet);
		
		return userDetail;
	}

}
