<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Filiais</title>
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
        <h1>Unidades Disponiveis</h1>
        <p>
        <hr class="style13">
        <div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Unidade</th>
                        <th>Rua</th>
                        <th>Numero</th>
                        <th>CEP</th>
                        <th>Telefone</th>
                        <th>Gerente</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lista}" var="p">    
                        <tr>
                            <td><a href='${pageContext.request.contextPath}/buscar-filial?idfilial="${p.id}"'> <c:out value="${p.nomeUnidade}" /> </a></td>
                            <td><c:out value="${p.rua}" /></td>
                            <td> <c:out value="${p.numero}" /></td>
                            <td><c:out value="${p.cep}" /></td>
                            <td><c:out value="${p.telefone}" /></td>
                            <td><c:out value="${p.gerente}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <p>

                <a href= "${pageContext.request.contextPath}/HomeFilialServlet" > Voltar </a> 
        </div>
    </body>
</html>
