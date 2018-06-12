<%-- 
    Document   : MenuPedido
    Created on : 28/05/2018, 18:56:52
    Author     : victor.galvao
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Pedido</title>
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
        <h1>Pesquisa o Cliente e Plano</h1>
        <p>
        <hr class="style13">
        <p>
        <form action="${pageContext.request.contextPath}/IniciarPedidoServlet" method="post">
            <div class="form-group col-md-8" >
                <div class="form-row col-md-4">
                    <label for="inputEmail4">Digite seu CPF</label>
                    <input type="number" class="form-control" placeholder="CPF" name="cpf">
                </div>
                <div class="form-row col-md-4">
                    <label for="inputAddress">Categoria De Planos</label>
                    <select class="form-control" name="class" >
                        <option value="0">Selecione</option>
                        <option value="1">Hatch</option>
                        <option value="2">Sedan</option>
                        <option value="3">SUV</option>
                        <option value="4">Picapes</option>
                        <option value="5">Esportivos</option>
                        <option value="6">Vans</option>
                    </select>
                </div>
            </div>
            <div class="form-group row right">
                <div class="col-sm-8">
                    <button type="submit" class="btn btn-primary">Pesquisar</button>
                </div>
            </div>
        </form>

    </body>
</html>
