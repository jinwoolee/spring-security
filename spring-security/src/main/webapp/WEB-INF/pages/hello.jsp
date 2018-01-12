<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Title : ${title}</h1>	
	<h1>Message : ${message}</h1>
	<h1>orgCd : ${USERVO.username} / ${USERVO.orgCd} / ${session.USERVO} </h1>
	
	property="principal.orgCd : <sec:authentication property="principal.orgCd"/> <br/>
	property="principal.test : <sec:authentication property="principal.test"/> <br/>
	
	<sec:authorize access="hasRole('ROLE_USER')">
		has role 'ROLE_USER'
	</sec:authorize>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:document.getElementById('logoutForm').submit();"> Logout</a>
		</h2>
	</c:if>
	
	<form action="/j_spring_security_logout" method="post" id="logoutForm">
	</form>
		
</body>
</html>