<%-- 
    Document   : ListarPlano
    Created on : 30/04/2018, 16:49:45
    Author     : victor.galvao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Planos Disponiveis</h1>
        <p>
        <hr class="style13">
        <div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Plano</th>
                        <th>Categoria</th>
                        <th>Valor</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lista}" var="p">    
                        <tr>
                            <td><a href='${pageContext.request.contextPath}/buscar-plano?id_plano="${p.idplano}"'> <c:out value="${p.plano}" /> </a></td>
                            <td><c:out value="${p.classificacao}" /></td>
                            <td> <c:out value="${p.valor}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <p>
                <a href= "${pageContext.request.contextPath}/HomeCarroServlet" > Voltar </a> 
        </div>
    </body>
</html>
