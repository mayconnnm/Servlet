<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- <c:url value="/alteraEmpresa" var="linkAlteraEmpresa"/> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="entrada" method="post">
		<div>
			<label>Nome:</label>
			<input type="text" name="nome" value="${empresa.nome}">
			<label>Data de Abertura:</label>
			<input type="text" name="dataAbertura" value="<fmt:formatDate value="${empresa.data}" pattern="dd/MM/yyyy"/>">
			<input type="hidden" name="id" value="${empresa.id}">
			<input type="hidden" name="acao" value="alterarEmpresa">
			<input type="submit">
		</div>
	</form>

</body>
</html>