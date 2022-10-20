<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<c:url value="/entrada" var="linkEntrada"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkEntrada}" method="post" >
		Nome: <input type="text" name="nome" value="${empresa.getNome()}"/>
		Data Abertura: <input type="text" name="data" value="<f:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/> " />	
		<input type="hidden" name="id" value="${empresa.id}"/>
 		<input type="hidden" name="acao" value="AlteraEmpresa"/>
		<input type="submit"/>
	</form>
</body>
</html>