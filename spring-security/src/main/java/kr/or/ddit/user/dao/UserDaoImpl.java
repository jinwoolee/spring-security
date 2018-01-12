package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserDetail;
import kr.or.ddit.user.model.UserRoles;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<UserDetail> usersByUsername(String username) {
		return sqlSession.selectList("usersByUsername", username);
	}

	@Override
	public UserRoles authoritiesByUsername(String username) {
		return sqlSession.selectOne("authoritiesByUsername", username);
	}
}
