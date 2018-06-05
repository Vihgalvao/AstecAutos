<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionarios Cadastrados</title>
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
        <h1>Funcionarios Cadastradas</h1>
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
                            <th>Estado</th>
                            <th>Cidade</th>
                            <th>Rua</th>
                            <th>Numero</th>
                            <th>Login</th>
                            <th>Cargo</th>
                            <th>Unidade</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${lista}" var="p">    
                            <tr>
                                <td><a href='${pageContext.request.contextPath}/buscar-funcionario?idfuncionario="${p.id}"'> <c:out value="${p.nome}" /> </a></td>
                                <td><c:out value="${p.sobrenome}" /></td>
                                <td><c:out value="${p.sexo}" /></td>
                                <td><c:out value="${p.cpf}" /></td>
                                <td><c:out value="${p.estado}" /></td>
                                <td><c:out value="${p.cidade}" /></td>
                                <td><c:out value="${p.rua}" /></td>
                                <td><c:out value="${p.numero}" /></td>
                                <td><c:out value="${p.login}" /></td>
                                <td><c:out value="${p.cargo}" /></td>
                                <td><c:out value="${p.filial}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <p>
                    <a href= "${pageContext.request.contextPath}/HomeFuncionarioServlet" > Voltar </a>   
            </div>
    </body>
</html>
