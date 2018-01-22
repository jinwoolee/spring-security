<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>hello.jsp</title>
<body>
	<h1>1. http://localhost:8080 또는 http://localhost:8080/spring_security_login</h1>
	<h1>2. 접속후 hello.jsp로 forward 확인</h1>
	<h1>3. http://localhost:8080/admin (인증된 사용자만 접속가능)으로 접속</h1>
	<h1>--> spring security 기본 로그인 페이지로 이동 </h1>
	<h2>brown을 제외 cony, james, moon, sally는 ROLE_USER 권한만 갖고 있음</h2>
	
	
	<h1>Title : ${title}</h1>	
	<h1>Message : ${message}</h1>
	
	<sec:authorize access="hasRole('ROLE_USER')">
		has role 'ROLE_USER'
	</sec:authorize>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | 
			<a href="javascript:document.getElementById('logoutForm').submit();"> Logout</a>
		</h2>
	</c:if>
	
	<form action="/j_spring_security_logout" method="post" id="logoutForm">
	</form>
		
</body>
</html>