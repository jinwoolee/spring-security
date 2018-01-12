<%@page session="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
	<h1>Title : ${title}</h1>	
	<h1>Message : ${message}</h1>
	
	<sec:authorize access="hasRole('ROLE_USER')">
		has role 'ROLE_USER'
	</sec:authorize>	
</body>
</html>