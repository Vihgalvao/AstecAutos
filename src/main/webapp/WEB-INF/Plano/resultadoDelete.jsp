<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete</title>
  </head>
  <body>
    <h1>Id Plano: <c:out value="${planoUpdate.plano}" /> deletado com sucesso</h1>
    <p>
    <a href= "${pageContext.request.contextPath}/HomePlanoServlet" > Voltar </a>  
  </body>
</html>
