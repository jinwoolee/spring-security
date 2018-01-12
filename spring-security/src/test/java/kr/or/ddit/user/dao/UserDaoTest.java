package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.user.model.UserDetail;
import kr.or.ddit.user.model.UserRoles;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
locations= {"classpath:/kr/or/ddit/spring/config/servlet-context.xml",
			"classpath:/kr/or/ddit/spring/config/spring-database.xml"})
public class UserDaoTest {

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Test
	public void usersByUsernameTest() {
		String username = "brown";
		
		List<UserDetail> userDetailList = userDao.usersByUsername(username);
		
		assertEquals(1, userDetailList.size());
	}
	
	@Test
	public void authoritiesByUsernameTest() {
		String username = "brown";
		
		UserRoles userRoles = userDao.authoritiesByUsername(username);
		
		assertEquals(2, userRoles.getRoles().size());
	}

}
