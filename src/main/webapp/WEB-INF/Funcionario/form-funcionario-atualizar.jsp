<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Funcionario</title>
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
            <h1>Atualize um Funcionario</h1>
        </div>
        <p>
        <hr class="style13">  
        <div>
            <form action="${pageContext.request.contextPath}/AtualizarFuncionario"
                  method="post">

                <div class="form-row" >
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-2">
                            <label for="inputEmail4">Id</label>
                            <input type="text" class="form-control" placeholder="Id" name="id" value= "${FuncionarioAtualizada.id}">
                        </div>
                        <div class="form-row col-md-2">
                            <label for="inputEmail4">Nome</label>
                            <input type="text" class="form-control" placeholder="Seu nome" name="nome" value= "${FuncionarioAtualizada.nome}">
                        </div>
                        <div class="form-row col-md-6">
                            <label for="inputPassword4">Sobrenome</label>
                            <input type="text" class="form-control" placeholder="Sobrenome" name="sobrenome" value= "${FuncionarioAtualizada.sobrenome}">
                        </div>
                        <div class="form-row col-md-2">
                            <label for="inputAddress">Sexo</label>
                            <select class="form-control" name="sexo" id="sexo">
                                <option value="0">Selecione</option>
                                <option value="1">Homem</option>
                                <option value="2">Mulher</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-6">
                            <label for="inputAddress">Rua</label>
                            <input type="text" class="form-control" placeholder="Rua" name="rua" value= "${FuncionarioAtualizada.rua}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Bairro</label>
                            <input type="text" class="form-control" placeholder="Bairro" name="bairro" value= "${FuncionarioAtualizada.bairro}">
                        </div>
                        <div class="form-row col-md-2">
                            <label for="inputAddress">Numero</label>
                            <input type="number" class="form-control" placeholder="Numero" name="numero" value= "${FuncionarioAtualizada.numero}">
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-4">
                            <label for="inputAddress">CEP</label>
                            <input type="text" class="form-control" placeholder="CEP" name="cep" value= "${FuncionarioAtualizada.cep}">
                        </div>
                        <div class="form-row col-md-4">
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
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Cidade</label>
                            <input type="text" class="form-control" placeholder="Cidade" name="cidade" value= "${FuncionarioAtualizada.cidade}">
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Cpf</label>
                            <input type="text" class="form-control" placeholder="CPF" name="cpf" value= "${FuncionarioAtualizada.cpf}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Data Nascimento</label>
                            <input type="date" class="form-control" placeholder="Data Nascimento" name="dtnascimento" value= "${FuncionarioAtualizada.dataNasc}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Email</label>
                            <input type="text" class="form-control" placeholder="Email" name="email" value= "${FuncionarioAtualizada.email}">
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Telefone</label>
                            <input type="text" class="form-control" placeholder="Telefone" name="telefone" value= "${FuncionarioAtualizada.telefone}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Cargo</label>
                            <select name="cargo" class="form-control" id="cargos">
                                <option value="1">Vendedor</option>
                                <option value="2">Gerente</option>
                                <option value="2">Diretor</option>
                            </select>
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Nivel</label>
                            <select name="nivel" class="form-control" id="nivelac">
                                <option value="1">Administrador</option>
                                <option value="2">Operacional</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Login</label>
                            <input type="text" class="form-control" placeholder="Login" name="login" value= "${FuncionarioAtualizada.login}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Senha</label>
                            <input type="password" class="form-control" placeholder="Senha" name="senha" value= "${FuncionarioAtualizada.senha}">
                        </div>

                        <div class="form-row col-md-4">
                            <label for="inputAddress">Filial</label>
                            <select name="filial" class="form-control" id="filial">
                                <option value="0">Selecione</option>
                                <c:forEach items="${filial}" var="p">
                                    <option value="${p.id}"> <c:out value="${p.nomeUnidade}"/> </option>
                                </c:forEach>
                            </select>
                        </div> 
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="customRadioInline1" name="metodo" class="custom-control-input" value="atualizar">
                            <label class="custom-control-label" for="customRadioInline1">Atualizar</label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="customRadioInline2" name="metodo" value="deletar" class="custom-control-input">
                            <label class="custom-control-label" for="customRadioInline2">Deletar</label>
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
                <a href= "${pageContext.request.contextPath}/HomeFuncionarioServlet" > Voltar </a>        

                <script>

                    var classe = "${FuncionarioAtualizada.idnivel}"
                    var element = document.querySelector('#nivelac')
                    element.selectedIndex = classe;

                    var classe2 = "${FuncionarioAtualizada.idcargo}"
                    var element2 = document.querySelector('#cargos')
                    element2.selectedIndex = classe2;

                    var sexo = "${FuncionarioAtualizada.idsexo}";
                    var element3 = document.querySelector('#sexo');
                    element3.selectedIndex = sexo;

                    var estado = "${FuncionarioAtualizada.idestado}";
                    var element4 = document.querySelector('#estado2');
                    element4.selectedIndex = estado;

                    var estado2 = "${FuncionarioAtualizada.idfilial}";
                    var element5 = document.querySelector('#filial');
                    element5.selectedIndex = estado2;

                </script>   

        </div>
    </body>
</html>
