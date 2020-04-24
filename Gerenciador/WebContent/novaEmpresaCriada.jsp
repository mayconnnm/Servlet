<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- <% --%>
<!--  	String nomeEmpresa = (String) request.getAttribute("nome"); -->
<%-- %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- A empresa <% out.println(novaEmpresa); %> foi cadastrada! --%>
	
	<%-- Com <%= imprime sem a necessidade do out.println --%>
	<%-- 	A empresa <%=nomeEmpresa%> foi cadastrada! --%>

	<!-- Se não for vazia -->
	<c:if test="${not empty nome}">
		<!-- Expression Language -->
		A empresa ${ nome } foi cadastrada na data <fmt:formatDate value="${dataAbertura}" pattern="dd/MM/yyyy"/> com sucesso!	
	</c:if>

	<c:if test="${empty nome}">
		Nenhuma empresa cadastrada, tente novamente!
	</c:if>

</body>
</html>