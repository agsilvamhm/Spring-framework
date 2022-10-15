<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<c:url value="/novaEmpresa" var="linkNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<form action="${linkNovaEmpresa}" method="post">
	
		Nome: <input type="text" name="nome" />
		
		<input type="submit"/>
		
	</form>
</body>
</html>