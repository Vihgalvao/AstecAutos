<%-- 
    Document   : form-cadastro-pedido
    Created on : 28/05/2018, 20:11:17
    Author     : victor.galvao
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastre um Pedido</title>
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
        <h1>Cadastre um Pedido</h1>
        <p>
        <hr class="style13">
        <p>
        <form action="${pageContext.request.contextPath}/cadastro-pedido" method="post">
            <div class="form-group col-md-8" >

                <h4 align="left" > Dados Pessoais: </h4>
                <hr class="style13">
                <p>
                    <input type="hidden" name="id" value="${cliente.id}">
                    <input type="hidden" name="filial" value="${idfilial}">
                    <label for="id"> Id: <c:out value="${cliente.id}"/> </label><br>
                    <label for="nome"> Nome: <c:out value="${cliente.nome}"/> </label><br>
                    <label for="sobrenome"> Sobrenome: <c:out value="${cliente.sobrenome}"/> </label><br>
                    <label for="cpf"> CPF: <c:out value="${cliente.cpf}"/> </label><br>
                    <label for="renda"> Renda: R$ <c:out value="${cliente.renda}"/> </label><br><br>
                <h4 align="left" > Endereço: </h4>
                <hr class="style13">
                <p>
                    <label for="rua"> Rua: <c:out value="${cliente.rua}"/> </label> <br>
                    <label for="numero"> Numero: <c:out value="${cliente.numero}"/> </label> <br>
                    <label for="bairro"> Bairro: <c:out value="${cliente.bairro}"/> </label> <br>
                    <label for="cep"> Cep: <c:out value="${cliente.cep}"/> </label> <br>
                    <label for="estado"> Estado: <c:out value="${cliente.estado}"/> </label> <br>

            </div>

            <div class="form-group col-md-8" >

                <div class="form-row col-md-8">
                    <label for="inputAddress">Funcionario</label>
                    <select name="funcionario" class="form-control" id="funcionario">
                        <option value="0">Selecione</option>
                        <c:forEach items="${funcionario}" var="p">
                            <option value="${p.id}"> <c:out value="${p.nome}"/> <c:out value="${p.sobrenome}"/></option>
                        </c:forEach>
                    </select>
                </div> 
            </div>
            <div class="form-group col-md-8" >
                <div class="form-row col-md-4">
                    <label for="inputAddress">Plano e Diaria</label>
                    <select name="plano" class="form-control" id="plano">
                        <option value="0">Selecione</option>
                        <c:forEach items="${plano}" var="p">
                            <option value="${p.idplano}"> <c:out value="${p.plano}"/> - R$ <c:out value="${p.valor}"/></option>
                        </c:forEach>
                    </select>
                </div> 
                <div class="form-row col-md-4">
                    <label for="inputAddress">Carros: </label>
                    <select name="carro" class="form-control" id="carro">
                        <option value="0">Selecione</option>
                        <c:forEach items="${carro}" var="p">
                            <option value="${p.idcarro}"> <c:out value="${p.carro}"/> </option>
                        </c:forEach>
                    </select>
                </div> 
            </div>
            <div class="form-group col-md-8" >
                <div class="form-row col-md-4">
                    <label for="inputEmail4">Data Retirada: </label>
                    <input type="date" class="form-control" placeholder="Data Retirada" name="dtretirada">
                </div>
                <div class="form-row col-md-4">
                    <label for="inputEmail4">Data Entrega: </label>
                    <input type="date" class="form-control" placeholder="Data Entrega" name="dtentrega">
                </div>
            </div>
            <div class="form-group row right">
                <div class="col-sm-8">
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </div>
            </div>
        </form>
        <p>
            <a href= "${pageContext.request.contextPath}/HomePedidoServlet" > Voltar </a>  


    </body>


</html>
