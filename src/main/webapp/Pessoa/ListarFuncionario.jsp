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
    <h1>Funcionarios Cadastradas</h1>
    <div>
      <ul>
	<c:forEach items="${lista}" var="p">
	  <li>
	    <h2><a href='http://localhost:8080/agendaweb-1.0-SNAPSHOT/buscar-funcionario?idfuncionario="${p.id}"'> Nome: <c:out value="${p.nome}" /> </a></h2>
	    <h2>Cidade: <c:out value="${p.cidade}" /></h2>
            <h2>Sobrenome: <c:out value="${p.sobrenome}" /></h2>
            <h2>CPF: <c:out value="${p.cpf}" /></h2>
            <h2>Cargo: <c:out value="${p.cargo}" /></h2>
            <h2>Nivel: <c:out value="${p.nivel}" /></h2>
	  </li>
	</c:forEach>
      </ul> <p>
        <a href= "http://localhost:8080/agendaweb-1.0-SNAPSHOT/Pessoa/FuncionarioInicio.jsp" > Voltar </a> 
    </div>
  </body>
</html>
