<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes Cadastrados</title>
        <style>
            hr.style13 {
                height: 10px;
                border: 0;
                box-shadow: 0 10px 10px -10px #8c8b8b inset;
            }  
        </style> 
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Pessoas Cadastradas</h1>
        <p>
        <hr class="style13">
        <div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Sobrenome</th>
                        <th>Sexo</th>
                        <th>Cpf</th>
                        <th>Data Nascimento</th>
                        <th>Estado</th>
                        <th>Cidade</th>
                        <th>Rua</th>
                        <th>Numero</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lista}" var="p">    
                        <tr>
                            <td><a href='${pageContext.request.contextPath}/buscar-cliente?idcliente="${p.id}"'> <c:out value="${p.nome}" /> </a></td>
                            <td><c:out value="${p.sobrenome}" /></td>
                            <td><c:out value="${p.sexo}" /></td>
                            <td><c:out value="${p.cpf}" /></td>
                            <td><c:out value="${p.dataNasc}" /></td>
                            <td><c:out value="${p.estado}" /></td>
                            <td><c:out value="${p.cidade}" /></td>
                            <td><c:out value="${p.rua}" /></td>
                            <td><c:out value="${p.numero}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <p>


            <p>
                <a href= "${pageContext.request.contextPath}/HomePessoaServlet" > Voltar </a>      
        </div>
    </body>
</html>
