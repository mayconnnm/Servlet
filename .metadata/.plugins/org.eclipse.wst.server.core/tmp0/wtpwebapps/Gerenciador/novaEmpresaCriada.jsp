<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String nomeEmpresa = (String) request.getAttribute("nome");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- A empresa <% out.println(novaEmpresa); %> foi cadastrada! --%>
	<%-- Com <%= imprime sem a necessidade do out.println --%>
	A empresa <%=nomeEmpresa%> foi cadastrada!

</body>
</html>