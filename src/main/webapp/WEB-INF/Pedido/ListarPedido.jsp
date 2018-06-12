<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos Cadastrados</title>
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

        <h3>Gerar Analitico - Pedidos </h3>
        <p>
        <hr class="style13">
        <FORM NAME="formRel" action="${pageContext.request.contextPath}/ListarPedidosServlet" METHOD="POST">
            <div class="form-group col-md-10" >
                <div class="form-row col-md-2">
                    <label for="inputAddress">Status</label>
                    <select name="status" class="form-control" id="filial">
                        <option value="0">Selecione</option>
                        <option value="1"> ATIVO   </option>
                        <option value="1"> BAIXADO </option>
                    </select>
                </div>
                <div class="form-row col-md-4">
                    <label for="inputEmail4">Data Inicial: </label>
                    <input type="date" class="form-control" placeholder="Data Inicio" name="dtini">
                </div>
                <div class="form-row col-md-4">
                    <label for="inputEmail4">Data Final: </label>
                    <input type="date" class="form-control" placeholder="Data Fim" name="dtfim">
                </div>
            </div>
            <div class="col-sm-8 col-md-4">
                <button type="submit" class="btn btn-primary">Gerar</button>
            </div>
    </form>
    <br>
    <br>
    <h3>Pedidos</h3>
    <p>
    <hr class="style13">
    <div>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Nome</th>
                    <th>Cpf</th>
                    <th>Filial</th>
                    <th>Plano</th>
                    <th>Carro</th>
                    <th>Data de Retirada</th>
                    <th>Data de Entrega</th>
                    <th>Valor Total</th>
                    <th>Status</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${lista}" var="p">    
                    <tr>
                        <td><a href='${pageContext.request.contextPath}/buscar-pedido?idpedido="${p.id}"'> <c:out value="${p.nomeCliente}" /> </a></td>
                        <td><c:out value="${p.cpf}" /></td>
                        <td><c:out value="${p.filial}" /></td>
                        <td><c:out value="${p.plano}" /></td>
                        <td><c:out value="${p.carro}" /></td>
                        <td><c:out value="${p.dtlocacao}" /></td>
                        <td><c:out value="${p.dtdevolucao}" /></td>
                        <td><c:out value="${p.valortotal}" /></td>
                        <td><c:out value="${p.dsStatus}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p>
            <a href= "${pageContext.request.contextPath}/HomeFuncionarioServlet" > Voltar </a>   
    </div>
</body>
</html>
