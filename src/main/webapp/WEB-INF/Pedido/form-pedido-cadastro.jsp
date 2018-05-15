<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Cadastre um Pedido!</h1>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/cadastro-pedido"
                  method="post">

                <div>
                    <c:forEach items="${listaPlano2}" var="p">
                        Planos:
                        <select name="idplano">
                            <option value="${listaPlano2.idplano}"> ${listaPlano2.plano + ' Valor: R$ ' + Double.toString(listaPlano2.valor)}</option>
                        </select>
                    </c:forEach>
                </div> <p>

                <div>
                    <c:forEach items="${listaCarro2}" var="p">
                        Carros:
                        <select name="idcarro">
                            <option value="${listaCarro2.idcarro}"> ${listaCarro2.carro}</option>
                        </select>
                    </c:forEach>
                </div>
                <!--<div>
                    Id Funcionario: <input type="text" name="id_funcionario" />
                </div> a definir ainda a classe de pessoa--> 


                <div>
                    <c:forEach items="${listaFilial}" var="p">
                        Filiais:
                        <select name="idfilial">
                            <option value="${listaFilial.idfilial}"> ${listaFilial.filial}</option>
                        </select>
                    </c:forEach>
                </div>


                <div>
                    Data Locação: <input type="date" name="dtlocacao" />
                </div>
                <div>
                    Data Devolução: <input type="date" name="dtdevolucao" />
                </div>

                <button type="submit">Enviar</button>
                <p>
                    
            </form>
            <a href= "http://localhost:8080/agendaweb-1.0-SNAPSHOT/Pedido.jsp" > Voltar </a>  

    </body>
</html>
