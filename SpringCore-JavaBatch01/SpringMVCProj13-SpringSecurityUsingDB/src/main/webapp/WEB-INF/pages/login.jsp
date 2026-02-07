<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>Login Page</h2>

<frm:form 
    action="${pageContext.request.contextPath}/login"
    method="post"
    modelAttribute="user">

    <div>
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
        <label>Username:</label>
        <frm:input path="username" />
    </div>
    <br>

    <div>
        <label>Password:</label>
        <frm:password path="password" />
    </div>
    <br>

    <input type="submit" value="Login" />

</frm:form>

</body>
</html>
