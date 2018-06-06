<%-- 
    Document   : resultadoCadastro
    Created on : 05/06/2018, 22:09:37
    Author     : victor.gsgalvao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Pedido cadastrado com sucesso</h1>
        <p>
        <a href= "${pageContext.request.contextPath}/HomePedidoServlet" > Voltar </a>    
    </body>
</html>