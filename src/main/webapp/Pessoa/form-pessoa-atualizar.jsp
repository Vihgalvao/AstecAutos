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
            <form action="${pageContext.request.contextPath}/AtualizarPessoa"
                  method="post">
                <div>
                    Id Pessoa: <input type="text" name="id" value= "${ClienteAtualizada.id}"/>
                </div>
                <div>
                    Nome: <input type="text" name="nome" value= "${ClienteAtualizada.nome}"/>
                </div>
                <div>
                    Sobrenome: <input type="text" name="sobrenome" value= "${ClienteAtualizada.sobrenome}"/>
                </div>
                <div>
                    Rua: <input type="text" name="rua" value= "${ClienteAtualizada.rua}"/>
                </div>  
                <div>
                    Numero: <input type="text" name="numero" value= "${ClienteAtualizada.numero}"/>
                </div>  
                <div>
                    Cep: <input type="text" name="cep" value= "${ClienteAtualizada.cep}"/>
                </div>
                <div>
                    Estado: <input type="text" name="estado" value= "${ClienteAtualizada.estado}"/>
                </div>
                <div>
                    Cidade: <input type="text" name="cidade" value= "${ClienteAtualizada.cidade}"/>
                </div>
                <div>
                    Cpf: <input type="text" name="cpf" value= "${ClienteAtualizada.cpf}"/>
                </div>
                <div>
                    Data Nascimento: <input type="date" name="dtnascimento" value= "${ClienteAtualizada.dataNasc}"/>
                </div>
                <div>
                    Email: <input type="text" name="email" value= "${ClienteAtualizada.email}"/>
                </div>
                <div>
                    Telefone: <input type="text" name="telefone" value= "${ClienteAtualizada.telefone}"/>
                </div>
                <div>
                    CNH: <input type="text" name="cnh" value= "${ClienteAtualizada.cnh}"/>
                </div>
                <div>
                    Renda Mensal: <input type="text" name="renda" value= "${ClienteAtualizada.renda}"/>
                </div>
                <div>
                    <input type="radio" name="metodo" value="atualizar"> Atualizar <br>
                    <input type="radio" name="metodo" value="deletar" checked> Deletar <br>
                </div> 


                <button type="submit">Enviar</button>
                <p>
            </form>
            <p>
                <a href= "${pageContext.request.contextPath}/HomePessoaServlet" > Voltar </a>         


        </div>
    </body>
</html>
