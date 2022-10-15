<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${not empty empresa}">
		<h2>Empresa ${empresa} cadastrada com sucesso!</h2>		
	</c:if>
	
	<c:if test="${empty empresa}">
		<h2>Nenhuma empresa cadastrada</h2>		
	</c:if>	
	
</body>
</html>