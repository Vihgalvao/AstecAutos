<%-- 
    Document   : resultadoRelatorio
    Created on : 03/06/2018, 00:45:08
    Author     : victor.galvao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Relatorio gerado com sucesso.</h1>
        <p>
            <a href= "${pageContext.request.contextPath}/HomePedidoServlet" > Voltar </a>       
    </body>
</html>
