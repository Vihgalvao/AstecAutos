<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Unidades Disponiveis</h1>
    <div>
      <ul>
	<c:forEach items="${filiais}" var="p">
	  <li>
	    <h2>Nome Unidade: <c:out value="${p.NomeUnidade}" /></h2>
	    <h2>Nome Rua: <c:out value="${p.Rua}" /></h2>
            <h2>Numero: <c:out value="${p.Numero}" /></h2>
            <h2>CEP: <c:out value="${p.Cep}" /></h2>
            <h2>Telefone: <c:out value="${p.Telefone}" /></h2>
            <h2>Gerente: <c:out value="${p.Gerente}" /></h2>
	  </li>
	</c:forEach>
      </ul> <p>
        <a href= "http://localhost:8080/agendaweb-1.0-SNAPSHOT/Filial.jsp" > Voltar </a> 
    </div>
  </body>
</html>
