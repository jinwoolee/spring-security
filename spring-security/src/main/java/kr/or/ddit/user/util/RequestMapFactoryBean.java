package kr.or.ddit.user.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import kr.or.ddit.role.dao.RoleDao;
import kr.or.ddit.role.model.RoleVo;

public class RequestMapFactoryBean implements FactoryBean<LinkedHashMap<RequestMatcher, List<ConfigAttribute>>> {

	@Resource(name = "roleDao")
	private RoleDao roleDao;

	private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> requestMap;
	
	public void init() {
		List<RoleVo> roleList = roleDao.getSecuredRoles();

		requestMap = new LinkedHashMap<RequestMatcher, List<ConfigAttribute>>();

		for (RoleVo vo : roleList) {
			RequestMatcher matcher = new AntPathRequestMatcher(vo.getResourcePattern());
			List<ConfigAttribute> attributes = requestMap.get(matcher);

			if (attributes == null)
				attributes = new LinkedList<ConfigAttribute>();

			attributes.add(new SecurityConfig(vo.getRole()));
			
			requestMap.put(matcher, attributes);
		}
	}

	@Override
	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getObject() throws Exception {
		return requestMap;
	}

	@Override
	public Class<?> getObjectType() {
		return requestMap.getClass();
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
