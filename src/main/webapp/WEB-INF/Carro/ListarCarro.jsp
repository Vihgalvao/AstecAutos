<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carros Disponiveis</title>
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
        <h1>Carros Disponiveis</h1>
        <p>
        <hr class="style13">
        <div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Carro</th>
                        <th>Fabricante</th>
                        <th>Cor</th>
                        <th>Ano</th>
                        <th>Valor</th>
                        <th>Categoria</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lista}" var="p">    
                        <tr>
                            <td><a href='${pageContext.request.contextPath}/buscar-carro?idcarro="${p.idcarro}"'> <c:out value="${p.carro}" /> </a></td>
                            <td><c:out value="${p.fabricante}" /></td>
                            <td> <c:out value="${p.cor}" /></td>
                            <td><c:out value="${p.ano}" /></td>
                            <td><c:out value="${p.valor}" /></td>
                            <td><c:out value="${p.classificacao}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <p>
                <a href= "${pageContext.request.contextPath}/HomeCarroServlet" > Voltar </a> 
        </div>
    </body>
</html>
