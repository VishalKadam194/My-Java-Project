<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<frm:form modelAttribute="user">
	<table>
		<tr>
		<td>Username::</td>
		<td><frm:input path="username"/></td>
		</tr>
		<tr>
		<td>Password::</td>
		<td><frm:input path="password"/></td>
		</tr>
		<tr>
		<td>Role:</td>
		<td>
			<select name = role>
			<option value="USER">ADMIN</option>
			<option value="ADMIN">USER</option>
				
			</select>
		</td>
		</tr>
		<tr>
		<td><input type ="submit" value="signup"/></td>
		</tr>
		
	
	</table>
</frm:form>
</body>
</html>