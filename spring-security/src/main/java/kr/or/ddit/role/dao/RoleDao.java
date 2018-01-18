package kr.or.ddit.role.dao;

import java.util.List;

import kr.or.ddit.role.model.RoleVo;
import kr.or.ddit.role.model.RolesHierarchyVo;

public interface RoleDao {
	
	//리소스-권한 매핑 정보 조회
	List<RoleVo> getSecuredRoles();

	//권한 계층 매핑 조회
	String getRolesHierarchy();

}
