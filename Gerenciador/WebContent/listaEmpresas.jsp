<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.alura.servlet.Empresa" %>
<%@ page import="java.util.List" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<%
			List<Empresa> listaEmpresas = (List<Empresa>) request.getAttribute("empresas");		
			for (Empresa empresa : listaEmpresas) {
				out.println("<li>" + empresa.getNome() + "</li>");
			}
		%>
	</ul>
</body>
</html>