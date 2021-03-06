<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.alura.modelo.Empresa" %>
<%@ page import="java.util.List" %>

<!-- Importando a lib para a jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- "Core" Controle de Fluxo -->

<!-- Importando a lib para a jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	<!-- "fmt" Formatação/ i18n (Internacionalização) -->
	
<%-- <c:url value="/removeEmpresa" var="linkRemoveEmpresa"/>	 --%>
	
<%-- <c:url value="/alteraEmpresa" var="linkAlteraEmpresa"/> --%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		Bem vindo ${usuarioLogado.login} &nbsp;&nbsp; <a href="entrada?acao=logout"><button>Sair</button></a>
	</div>
	<br>
	<br>
	<br>
	
	<!-- 	<ul> -->
	<%-- 		<% --%>
	<!-- 			List<Empresa> listaEmpresas = (List<Empresa>) request.getAttribute("empresas");		 -->
	<!-- 			for (Empresa empresa : listaEmpresas) { -->
	<!-- 				out.println("<li>" + empresa.getNome() + "</li>"); -->
	<!-- 			} -->
	<!-- 		%> -->
	<!-- 	</ul> -->

	<c:if test="${not empty empresas }">
		<!-- Expression Language -->
		A empresa foi cadastrada com sucesso!	
	</c:if>

	<c:if test="${empty empresas}">
		Nenhuma empresa cadastrada, tente novamente!
	</c:if>

	<ul>
		<!-- Fazendo um laço baseado nesse item "empresas" e nomeando para "empresa" -->
		<c:forEach items="${empresas}" var="empresa">
			<!-- Formatando a data para o padrão específico -->
			<c:if test="${not empty empresa.data }">
				<li>Nome da Empresa: ${empresa.nome } | Data de Abertura: <fmt:formatDate value="${empresa.data}" pattern="dd/MM/yyyy"/> &nbsp;&nbsp;&nbsp;<a href="entrada?acao=detalhesEmpresa&id=${empresa.id}"><button>Alterar</button></a> &nbsp;&nbsp;&nbsp;<a href="entrada?acao=removerEmpresa&id=${empresa.id}"><button>Remover</button></a></li>
				<br/>
			</c:if>
			<c:if test="${empty empresa.data }">
				<li>Nome da Empresa: ${empresa.nome } | Data de Abertura: - &nbsp;&nbsp;&nbsp;<a href="entrada?acao=detalhesEmpresa&id=${empresa.id}"><button>Alterar</button></a> &nbsp;&nbsp;&nbsp;<a href="entrada?acao=removerEmpresa&id=${empresa.id}"><button>Remover</button></a></li>
				<br/>
			</c:if>
		</c:forEach>
	</ul>

</body>
</html>