package kr.or.ddit.role.util;

import javax.annotation.Resource;

import org.springframework.beans.factory.FactoryBean;

import kr.or.ddit.role.dao.RoleDao;

public class CustomRoleHierarchy implements FactoryBean<String>{

	@Resource(name="roleDao")
	private RoleDao roleDao;
	
	@Override
	public String getObject() throws Exception {
		return roleDao.getRolesHierarchy();
	}

	@Override
	public Class<?> getObjectType() {
		return String.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
