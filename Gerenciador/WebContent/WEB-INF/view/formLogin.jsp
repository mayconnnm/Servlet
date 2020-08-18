<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="entrada" method="post">
		<div>
			<label>Login:</label>
			<input type="text" name="login">
			<label>Senha:</label>
			<input type="password" name="senha">
			<input type="hidden" name="acao" value="acessarUsuario">
			<input type="submit">
		</div>
	</form>

</body>
</html>