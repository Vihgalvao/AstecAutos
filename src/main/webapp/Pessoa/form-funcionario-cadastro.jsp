<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div> 
            <h1>Cadastre um Carro</h1>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/cadastro-funcionario"
                  method="post">
                <div>
                    Nome: <input type="text" name="nome" />
                </div>
                <div>
                    Sobrenome: <input type="text" name="sobrenome" />
                </div>
                <div>
                    Rua: <input type="text" name="rua" />
                </div>  
                <div>
                    Numero: <input type="text" name="numero" />
                </div>  
                <div>
                    Cep: <input type="text" name="cep"/>
                </div>
                <div>
                    Estado: <input type="text" name="estado"/>
                </div>
                <div>
                    Cidade: <input type="text" name="cidade"/>
                </div>
                <div>
                    Cpf: <input type="text" name="cpf"/>
                </div>
                <div>
                    Data Nascimento: <input type="date" name="dtnascimento" />
                </div>
                <div>
                    Email: <input type="text" name="email"/>
                </div>
                <div>
                    Telefone: <input type="text" name="telefone"/>
                </div>
                <div>
                    Cargo:
                    <select name="cargo">
                        <option value="1">Vendedor</option>
                        <option value="2">Gerente</option>
                        <option value="2">Diretor</option>
                    </select>
                </div>
                <div>
                    Nivel:
                    <select name="nivel">
                        <option value="1">Administrador</option>
                        <option value="2">Operacional</option>
                    </select>
                </div>
                <div>
                    Login: <input type="text" name="login"/>
                </div>
                <div>
                    Senha: <input type="password" name="senha"/>
                </div>

                <button type="submit">Enviar</button>
                <p>
            </form>
            <p>
                <a href= "${pageContext.request.contextPath}/HomeFuncionarioServlet" > Voltar </a>     


        </div>
    </body>
</html>
