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
		Login: <input type="text" name="login" />
		Senha: <input type="password" name="senha" />	
		<input type="hidden" name="acao" value="Login"/>
		<input type="submit"/>
	</form>
</body>
</html>