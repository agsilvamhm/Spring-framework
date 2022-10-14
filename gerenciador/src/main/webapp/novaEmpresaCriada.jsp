<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// Scriptlet

String nomeEmpresa = "Alura";
%>

<h2>Empresa <% out.println(nomeEmpresa); %> cadastrada com sucesso!</h2>

<h2>Empresa <%=nomeEmpresa %> cadastrada com sucesso!</h2>
</body>
</html>