<%-- 
    Document   : erro
    Created on : 01/06/2018, 19:37:20
    Author     : victor.galvao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        
        <h1><c:out value="${erro}" /></h1>
        <p>
            <a href= "${pageContext.request.contextPath}/HomeFuncionarioServlet" > Voltar </a>  
    </body>

</html>
