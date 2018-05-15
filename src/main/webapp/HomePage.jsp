<%-- 
    Document   : HomePage
    Created on : 15/05/2018, 14:23:33
    Author     : victor.galvao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LOCADORA DE VEICULOS</h1>
        <h3><a href= "${pageContext.request.contextPath}/HomeCarroServlet" > Carros </a> </h3><p>
        <h3><a href= "${pageContext.request.contextPath}/HomeFuncionarioServlet" > Funcionarios </a> </h3><p>
        <h3><a href= "${pageContext.request.contextPath}/HomePessoaServlet" > Clientes </a> </h3><p> 
        <h3><a href= "${pageContext.request.contextPath}/HomeFilialServlet" > Filiais </a> </h3><p> 
    
    <h5><a href="${pageContext.request.contextPath}/Sair"> Logout </a></h5>
    </body>
    
    
</html>
