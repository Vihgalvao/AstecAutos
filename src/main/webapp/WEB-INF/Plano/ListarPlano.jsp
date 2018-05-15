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
    <h1>Planos Disponiveis</h1>
    <div>
      <ul>
	<c:forEach items="${lista}" var="p">
	  <li>
	    <h2><a href='http://localhost:8080/agendaweb-1.0-SNAPSHOT/buscar-plano?id_plano="${p.idplano}"'> Nome Plano <c:out value="${p.plano}" /> </a></h2>
	    <h2> Classificação: <c:out value="${p.classificacao}" /></h2>
            <h2> Valor: <c:out value="${p.valor}" /></h2>
	  </li>
	</c:forEach>
      </ul> <p>
        <a href= "${pageContext.request.contextPath}/HomePlanoServlet" > Voltar </a>  
    </div>
    </body>
</html>
