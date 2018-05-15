<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div> 
            <h1>Cadastre um Funcionario</h1>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/AtualizarFuncionario"
                  method="post">
                <div>
                    Id Pessoa: <input type="text" name="id" value= "${FuncionarioAtualizada.id}"/>
                </div>
                <div>
                    Nome: <input type="text" name="nome" value= "${FuncionarioAtualizada.nome}"/>
                </div>
                <div>
                    Sobrenome: <input type="text" name="sobrenome" value= "${FuncionarioAtualizada.sobrenome}"/>
                </div>
                <div>
                    Rua: <input type="text" name="rua" value= "${FuncionarioAtualizada.rua}"/>
                </div>  
                <div>
                    Numero: <input type="text" name="numero" value= "${FuncionarioAtualizada.numero}"/>
                </div>  
                <div>
                    Cep: <input type="text" name="cep" value= "${FuncionarioAtualizada.cep}"/>
                </div>
                <div>
                    Estado: <input type="text" name="estado" value= "${FuncionarioAtualizada.estado}"/>
                </div>
                <div>
                    Cidade: <input type="text" name="cidade" value= "${FuncionarioAtualizada.cidade}"/>
                </div>
                <div>
                    Cpf: <input type="text" name="cpf" value= "${FuncionarioAtualizada.cpf}"/>
                </div>
                <div>
                    Data Nascimento: <input type="date" name="dtnascimento" value= "${FuncionarioAtualizada.dataNasc}"/>
                </div>
                <div>
                    Email: <input type="text" name="email" value= "${FuncionarioAtualizada.email}"/>
                </div>
                <div>
                    Telefone: <input type="text" name="telefone" value= "${FuncionarioAtualizada.telefone}"/>
                </div>
                <div>
                    Cargo:
                    <select name="cargo" id="cargos">
                        <option value="1">Vendedor</option>
                        <option value="2">Gerente</option>
                        <option value="2">Diretor</option>
                    </select>
                </div>
                <div>
                    Nivel:
                    <select name="nivel" id="nivelac">
                        <option value="1">Administrador</option>
                        <option value="2">Operacional</option>
                    </select>
                </div>
                <div>
                    Login: <input type="text" name="login" value= "${FuncionarioAtualizada.login}"/>
                </div>
                <div>
                    Senha: <input type="password" name="senha" value= "${FuncionarioAtualizada.senha}"/>
                </div>



                <div>
                    <input type="radio" name="metodo" value="atualizar"> Atualizar <br>
                    <input type="radio" name="metodo" value="deletar" checked> Deletar <br>
                </div> 


                <button type="submit">Enviar</button>
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

                </script>   

        </div>
    </body>
</html>
