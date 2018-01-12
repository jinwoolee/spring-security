package kr.or.ddit.user.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.model.UserRoles;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public UserVo usersByUsername(String username) {
		return sqlSession.selectOne("usersByUsername", username);
	}

	@Override
	public UserRoles authoritiesByUsername(String username) {
		return sqlSession.selectOne("authoritiesByUsername", username);
	}
}
