<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>

<c:set var="contexRoot" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>

<html class='no-js' lang='en'>
<head>
<meta charset='utf-8'>
<meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
<title>Dashboard</title>
<meta content='lab2023' name='author'>
<meta content='' name='description'>
<meta content='' name='keywords'>
<link href="${css}/application.css" rel="stylesheet" type="text/css" />
<link href="${css}/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<link href="${images}/favicon.ico" rel="icon" type="image/ico" />
<link href="${css}/font-awesome.css" rel="stylesheet" type="text/css" />
<link href="${css}/pessoal.css" rel="stylesheet" type="text/css" />

<script>
	window.contextRoot = '${contextRoot}';
</script>

</head>
<body class='main page'>

	<!-- Navbar -->
	<%@include file="./shared/navbar.jsp"%>
	<!-- End of Navbar-->

	<div id='wrapper'>

		<!-- Sidebar -->
		<%@include file="./shared/sidebar.jsp"%>
		<!-- End of Sidebar-->

		<!-- Tools -->
		<%@include file="./shared/tools.jsp"%>
		<!-- End of Tools-->

		<!-- Content -->

		<c:if test="${userClickComanda == true}">
			<%@include file="comanda.jsp"%>
		</c:if>

		<c:if test="${userClickConfig == true}">
			<%@include file="config.jsp"%>
		</c:if>

		<c:if test="${userClickComandaGerenciamento == true}">
			<%@include file="comanda-gerenciamento.jsp"%>
		</c:if>

		<c:if test="${userClickComandaCadastro == true}">
			<%@include file="comanda-cadastro.jsp"%>
		</c:if>

		<c:if test="${userClickGerirProduto == true}">
			<%@include file="produto-cadastro.jsp"%>
		</c:if>

		<c:if test="${userClickGerirCliente == true}">
			<%@include file="cliente-cadastro.jsp"%>
		</c:if>

		<c:if test="${userClickGerirGrupo == true}">
			<%@include file="grupo-cadastro.jsp"%>
		</c:if>

		<c:if test="${userClickGerirLocalizacao == true}">
			<%@include file="localizacao-cadastro.jsp"%>
		</c:if>
		
		<c:if test="${userClickComandaFechamento == true}">
			<%@include file="fechamento.jsp" %>
		</c:if>
		

		<!-- End of Content  -->

	</div>

	<!-- Footer -->



	<!-- Javascripts -->
	<script src="${js}/jquery.min.js" type="text/javascript"></script>
	<script src="${js}/jquery-ui.min.js" type="text/javascript"></script>
	<script src="${js}/modernizr.min.js" type="text/javascript"></script>
	<script src="${js}/application.js" type="text/javascript"></script>
	<script src="${js}/pessoal.js" type="text/javascript"></script>
	<script src="${js}/mascara-data.js" type="text/javascript"></script>
	<script src="${js}/jquery.maskMoney.js" type="text/javascript"></script>
	<!-- Google Analytics -->
	
	<script type="text/javascript">
	$(function() {
		$(".preco").maskMoney({
			symbol : 'R$ ',
			showSymbol : true,
			thousands : '.',
			decimal : ',',
			symbolStay : false,
			precision: 2
			
		});
	})
</script>

</body>
</html>
