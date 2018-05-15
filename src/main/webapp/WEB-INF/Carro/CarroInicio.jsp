<%-- 
    Document   : Home
    Created on : 17/04/2018, 12:37:51
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
        <h1>Carros</h1><p>
        <ul>
            <li><h3><a href="${pageContext.request.contextPath}/cadastro-carro"> Cadastro </a></h3></li>
            <li><h3><a href="${pageContext.request.contextPath}/ListarCarrosServlet"> Listar Todas </a></h3></li>
        </ul>  
        
        <h5><a href="${pageContext.request.contextPath}/HomeServlet"> Voltar </a></h5>
    </body>
</html>
