<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>

<c:set var="contexRoot" value="${pageContex.request.contextPath }"></c:set>

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

</head>
<body class='main page'>

	<!-- Navbar -->
	<%@include file="./shared/navbar.jsp"%>
	<!-- End of Navbar-->
	
	<div id='wrapper'>

		<!-- Sidebar -->
		<%@include file="./shared/sidebar.jsp" %>
		<!-- End of Sidebar-->

		<!-- Tools -->
		<%@include file="./shared/tools.jsp" %>
		<!-- End of Tools-->
		
		<!-- Content -->

		<c:if test="${userClickComanda == true}">
			<%@include file="comanda.jsp" %>
		</c:if>
		
		<c:if test="${UserClickConfig == true}">
			<%@include file="config.jsp" %>
		</c:if>

		<c:if test="${UserClickComandaGerenciamento == true}">
			<%@include file="comanda-gerenciamento.jsp" %>
		</c:if>
		
		<c:if test="${UserClickComandaCadastro == true}">
			<%@include file="comanda-cadastro.jsp" %>
		</c:if>


		<!-- End of Content  -->
		
	</div>
	
	<!-- Footer -->
	
	
	
	<!-- Javascripts -->
	<script src="${js}/jquery.min.js" type="text/javascript"></script>
	<script src="${js}/jquery-ui.min.js" type="text/javascript"></script>
	<script src="${js}/modernizr.min.js" type="text/javascript"></script>
	<script src="${js}/application.js" type="text/javascript"></script>
	<!-- Google Analytics -->

</body>
</html>
