package kr.or.ddit.user.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import kr.or.ddit.user.model.UserDetail;
import kr.or.ddit.user.model.UserVo;

public class AuthenticationSuccessHandlerImpl extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		
		logger.debug("{}", "onAuthenticationSuccess()");
		
		HttpSession session = request.getSession();

		UserDetail userDetail = (UserDetail)authentication.getPrincipal();
		
		UserVo userVo = new UserVo();
		userVo.setupUserVo(userDetail);
		
		logger.debug("{}", userVo);
		
		session.setAttribute("USERVO", userVo);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
