package kr.or.ddit.role.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.role.model.RoleVo;
import kr.or.ddit.role.model.RolesHierarchyVo;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSession sqlSession;

	//리소스-권한 매핑 정보 조회
	@Override
	public List<RoleVo> getSecuredRoles() {
		return sqlSession.selectList("getSecuredRoles");
	}

	//권한 계층 매핑 조회
	@Override
	public String getRolesHierarchy() {
		return sqlSession.selectOne("getRolesHierarchy");
	}
	
}
