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
        <title>Atualizar Pedido</title>
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
        <h1>Atualize o Pedido</h1>
        <p>
        <hr class="style13">
        <p>
        <form action="${pageContext.request.contextPath}/atualizar-pedido" method="post">
            <div class="form-group col-md-8" >

                <h4 align="left" > Dados Pessoais: </h4>
                <hr class="style13">
                <p>
                    <input type="hidden" name="id" value="${cliente.id}">
                    <input type="hidden" name="idpedido" value="${pedido.id}">
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
                <div class="form-row col-md-4">
                    <label for="inputAddress">Filial</label>
                    <select name="filial2" class="form-control" id="filial">
                        <option value="0">Selecione</option>
                        <c:forEach items="${filial}" var="p">
                            <option value="${p.id}"> <c:out value="${p.nomeUnidade}"/> </option>
                        </c:forEach>
                    </select>
                </div> 
                <div class="form-row col-md-4">
                    <label for="inputAddress">Funcionario</label>
                    <select name="funcionario2" class="form-control" id="funcionario">
                        <option value="0">Selecione</option>
                        <c:forEach items="${funcionario}" var="p">
                            <option value="${p.id}"> <c:out value="${p.nome}"/> </option>
                        </c:forEach>
                    </select>
                </div> 
            </div>
            <div class="form-group col-md-8" >
                <div class="form-row col-md-4">
                    <label for="inputAddress">Plano e Diaria</label>
                    <select name="plano2" class="form-control" id="plano">
                        <option value="0">Selecione</option>
                        <c:forEach items="${plano}" var="p">
                            <option value="${p.idplano}"> <c:out value="${p.plano}"/> - R$ <c:out value="${p.valor}"/></option>
                        </c:forEach>
                    </select>
                </div> 
                <div class="form-row col-md-4">
                    <label for="inputAddress">Carros: </label>
                    <select name="carro2" class="form-control" id="carro">
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
                    <input type="date" class="form-control" placeholder="Data Retirada" name="dtretirada" value="${pedido.dtlocacao}">
                </div>
                <div class="form-row col-md-4">
                    <label for="inputEmail4">Data Entrega: </label>
                    <input type="date" class="form-control" placeholder="Data Entrega" name="dtdevolucao" value="${pedido.dtdevolucao}">
                </div>
                <div class="form-row col-md-2">
                    <label for="inputAddress">Status Pedido</label>
                    <select class="form-control" name="statuspedido" id="pedido">
                        <option value="0">Selecione</option>
                        <option value="1">ATIVO</option>
                        <option value="2">BAIXADO</option>
                    </select>
                </div>
            </div>
            <div class="form-group row right">
                <div class="col-sm-8">
                    <button type="submit" class="btn btn-primary">Atualizar</button>
                </div>
            </div>
        </form>
        <p>
            <a href= "${pageContext.request.contextPath}/HomePedidoServlet" > Voltar </a>  
            <script>

                var idpedido = "${pedido.status}";
                var element = document.querySelector('#pedido');
                element.value = idpedido;


                var idfilial = "${pedido.idfilial}";
                var element2 = document.querySelector('#filial');
                element2.value = idfilial;

                var idplano = "${pedido.idplano}";
                var element3 = document.querySelector('#plano');
                element3.value = idplano;
                console.log(element3);

                var idfunc = "${pedido.idfuncionario}";
                var element4 = document.querySelector('#funcionario');
                element4.value = idfunc;

                var idcarro = "${pedido.idcarro}";
                var element5 = document.querySelector('#carro');
                element5.value = idcarro;

                console.log(idpedido);
                console.log(idfilial);
                console.log(idplano);
                console.log(idfunc);
                console.log(idcarro);
            </script>  

    </body>


</html>
