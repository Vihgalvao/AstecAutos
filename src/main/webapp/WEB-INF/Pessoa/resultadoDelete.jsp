<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete</title>
  </head>
  <body>
      <jsp:include page="menu.jsp"/>
    <h1>Id carro: <c:out value="${ClienteUpdate.id}" /> deletado com sucesso</h1>
    <p>
    <a href= "${pageContext.request.contextPath}/HomePessoaServlet" > Voltar </a>      
  </body>
</html>
