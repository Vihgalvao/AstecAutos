<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Id filia: <c:out value="${delete}" /> deletado com sucesso</h1>
    <p>
    <a href= "http://localhost:8080/agendaweb-1.0-SNAPSHOT/Filial.jsp" > Voltar </a> 
  </body>
</html>