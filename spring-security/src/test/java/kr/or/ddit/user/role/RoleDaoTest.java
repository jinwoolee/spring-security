package kr.or.ddit.user.role;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.role.dao.RoleDao;
import kr.or.ddit.role.model.RoleVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		value= {"classpath:kr/or/ddit/spring/config/spring-context.xml",
				"classpath:kr/or/ddit/spring/config/spring-database.xml"})
public class RoleDaoTest {
	
	private Logger logger = LoggerFactory.getLogger(RoleDaoTest.class);
	
	
	@Resource(name="roleDao")
	private RoleDao roleDao;

	//권한 정보 조회
	@Test
	public void getSecuredRolesTest() {
		List<RoleVo> roleList = roleDao.getSecuredRoles();
		
		for(RoleVo vo : roleList)
			logger.debug("{}", vo);
		assertTrue(roleList.size() > 0);
	}
	
	//권한 계층 정보 조회
	@Test
	public void getRoleHierarcyTest() {
		String hierarchyStr = roleDao.getRolesHierarchy();
		logger.debug("{}", hierarchyStr);
		assertEquals("ROLE_ADMIN > ROLE_USER", hierarchyStr);
	}

}
