<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/> 
	<br/>
	<br/>
	Usuario Logado: ${usuarioLogado.login} 
	<br/>
	<br/>

	<c:if test="${not empty empresa}">
		<h2>Empresa ${empresa} cadastrada com sucesso!</h2>		
	</c:if>

<h2>Lista de Empresas:</h2>
<ul>  	
	<c:forEach items="${empresas}" var="empresa">
		<li>${empresa.nome } - <f:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
		<a href="/mhm/entrada?acao=MostrarEmpresa&id=${empresa.id}">editar</a>
		<a href="/mhm/entrada?acao=RemoverEmpresa&id=${empresa.id}">remove</a>
		</li>	
	</c:forEach>
</ul>

</body>
</html>