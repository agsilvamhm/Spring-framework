<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<c:url value="/entrada" var="linkNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/> 

	<form action="${linkNovaEmpresa}" method="post">
		Nome: <input type="text" name="nome" />
		Data Abertura: <input type="text" name="data" />	
		<input type="hidden" name="acao" value="CriarEmpresa"/>
		<input type="submit"/>
	</form>
</body>
</html>