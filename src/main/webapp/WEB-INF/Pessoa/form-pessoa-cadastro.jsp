<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div> 
            <h1>Cadastre um Cliente</h1>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/cadastro-cliente"
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
                    CNH: <input type="text" name="cnh"/>
                </div>
                <div>
                    Renda Mensal: <input type="text" name="renda"/>
                </div>


                <button type="submit">Enviar</button>
                <p>
            </form>
            <p>
                <a href= "${pageContext.request.contextPath}/HomePessoaServlet" > Voltar </a>         


        </div>
    </body>
</html>
