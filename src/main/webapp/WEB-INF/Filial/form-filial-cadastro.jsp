<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastre Filial</title>
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
        <div> 
            <h1>Cadastre uma Filial</h1>
        </div>
        <p>
        <hr class="style13">
        <div>
            <form action="${pageContext.request.contextPath}/cadastro-filial"
                  method="post">

                <div class="form-row" >
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-6">
                            <label for="inputEmail4">Nome Filial</label>
                            <input type="text" class="form-control" placeholder="Nome Filial" name="nome">
                        </div>
                        <div class="form-row col-md-6">
                            <label for="inputPassword4">Rua</label>
                            <input type="text" class="form-control" placeholder="Rua" name="rua">
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Numero</label>
                            <input type="text" class="form-control" placeholder="Numero Filial" name="numero">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">CEP</label>
                            <input type="number" class="form-control" placeholder="CEP" name="cep">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Telefone Filial (Apenas Numeros):</label>
                            <input type="number" class="form-control" placeholder="Telefone" name="telefone">
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-6">
                            <label for="inputAddress">Gerente</label>
                            <input type="text" class="form-control" placeholder="Gerente" name="gerente">
                        </div>
                        <div class="form-row col-md-6">
                            <label for="inputAddress">Estado</label>
                            <select class="form-control" name="estado" id="estado2">
                                <option value="0">Selecione</option>
                                <option value="1">Acre</option>
                                <option value="2">Alagoas</option>
                                <option value="3">Amapá</option>
                                <option value="4">Amazonas</option>
                                <option value="5">Bahia</option>
                                <option value="5">Ceara</option>
                                <option value="7">Distrito Federal</option>
                                <option value="8">Espírito Santo</option>
                                <option value="9">Goiás</option>
                                <option value="10">Maranhão</option>
                                <option value="11">Mato Grosso</option>
                                <option value="12">Mato Grosso do Sul</option>
                                <option value="13">Minas Gerais</option>
                                <option value="14">Pará</option>
                                <option value="15">Paraíba</option>
                                <option value="16">Paraná</option>
                                <option value="17">Pernambuco</option>
                                <option value="18">Piauí</option>
                                <option value="19">Rio de Janeiro</option>
                                <option value="20">Rio Grande do Norte</option>
                                <option value="21">Rio Grande do Sul</option>
                                <option value="22">Rondônia</option>
                                <option value="23">Roraima</option>
                                <option value="24">Santa Catarina</option>
                                <option value="25">São Paulo</option>
                                <option value="26">Sergipe</option>
                                <option value="27">Tocantins</option>
                            </select>
                        </div>
                    </div>
                </div>
                <p>

                <div class="form-group row right">
                    <div class="col-sm-8">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                    </div>
                </div>

                <p>
            </form>
            <p>
                <a href= "${pageContext.request.contextPath}/HomeFilialServlet" > Voltar </a>   


        </div>
    </body>
</html>
