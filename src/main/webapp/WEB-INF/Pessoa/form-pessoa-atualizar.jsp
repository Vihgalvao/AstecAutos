<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Cliente</title>
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
            <h1>Atualizar Cliente</h1>
        </div>
        <p>
        <hr class="style13">  
        <div>
            <form action="${pageContext.request.contextPath}/AtualizarPessoa"
                  method="post">

                <div class="form-row" >
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-2">
                            <label for="inputEmail4">Id</label>
                            <input type="text" class="form-control" placeholder="Id" name="id" value= "${ClienteAtualizada.id}"> 
                        </div>
                        <div class="form-row col-md-2">
                            <label for="inputEmail4">Nome</label>
                            <input type="text" class="form-control" placeholder="Seu nome" name="nome" value= "${ClienteAtualizada.nome}"> 
                        </div>
                        <div class="form-row col-md-6">
                            <label for="inputPassword4">Sobrenome</label>
                            <input type="text" class="form-control" placeholder="Sobrenome" name="sobrenome" value="${ClienteAtualizada.sobrenome}">
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
                            <input type="text" class="form-control" placeholder="Rua" name="rua" value= "${ClienteAtualizada.rua}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Bairro</label>
                            <input type="text" class="form-control" placeholder="Bairro" name="bairro" value= "${ClienteAtualizada.bairro}">
                                   </div>
                                   <div class="form-row col-md-2">
                                   <label for="inputAddress">Numero</label>
                            <input type="number" class="form-control" placeholder="Numero" name="numero" value= "${ClienteAtualizada.numero}">
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-4">
                            <label for="inputAddress">CEP</label>
                            <input type="text" class="form-control" placeholder="CEP" name="cep" value= "${ClienteAtualizada.cep}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Estado</label>
                            <select class="form-control" name="estado" id="estado">
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
                            <input type="text" class="form-control" placeholder="Cidade" name="cidade" value= "${ClienteAtualizada.cidade}">
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Cpf</label>
                            <input type="text" class="form-control" placeholder="CPF" name="cpf" value="${ClienteAtualizada.cpf}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Data Nascimento</label>
                            <input type="date" class="form-control" placeholder="Data Nascimento" name="dtnascimento" value= "${ClienteAtualizada.dataNasc}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Email</label>
                            <input type="text" class="form-control" placeholder="Email" name="email" value= "${ClienteAtualizada.email}">
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Telefone</label>
                            <input type="text" class="form-control" placeholder="Telefone" name="telefone" value= "${ClienteAtualizada.telefone}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">CNH</label>
                            <input type="text" class="form-control" placeholder="CNH" name="cnh" value= "${ClienteAtualizada.cnh}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Rensa Mensal</label>
                            <input type="text" class="form-control" placeholder="Renda Mensal" name="renda" value= "${ClienteAtualizada.renda}">
                        </div>
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
                <p>

                <div class="form-group row right">
                    <div class="col-sm-8">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </div>

                <p>
            </form>
            <p>
                <a href= "${pageContext.request.contextPath}/HomePessoaServlet" > Voltar </a>         

        </div>

        <script>

            var sexo = "${ClienteAtualizada.idsexo}";
            var element = document.querySelector('#sexo');
            element.selectedIndex = sexo;

            var estado = "${ClienteAtualizada.idestado}";
            var element2 = document.querySelector('#estado');
            element2.selectedIndex = estado;

        </script>  
    </body>
</html>
