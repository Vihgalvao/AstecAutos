<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div> 
            <h1>Atualizar uma Filial</h1>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/AtualizarFilial"
                  method="post">
                
                 <div>
                    Id Filial: <input type="text" name="id" value= "${pessoaAtualizada.id}"/>
                </div>

                <div>
                    Nome Filial: <input type="text" name="nome" value= "${pessoaAtualizada.nomeUnidade}" />
                </div>
                <div>
                    Rua <input type="text" name="rua" value= "${pessoaAtualizada.rua}"/>
                </div> 

                <div>
                    Numero: <input type="text" name="numero" value= "${pessoaAtualizada.numero}"/>
                </div>  
                <div>
                    CEP <input type="text" name="cep" value= "${pessoaAtualizada.cep}"/>
                </div>   
                <div>
                    Telefone Filial (Apenas Numeros): <input type="text" name="telefone" value= "${pessoaAtualizada.telefone}"/>
                </div>
                <div>
                    Gerente: <input type="text" name="gerente" value= "${pessoaAtualizada.gerente}"/>
                </div> 
                <div>
                  <input type="radio" name="metodo" value="atualizar"> Atualizar <br>
                  <input type="radio" name="metodo" value="deletar" checked> Deletar <br>
                </div> 
                <button type="submit">Salvar</button>
            </form>
            <p> 
               <a href= "${pageContext.request.contextPath}/HomeFilialServlet" > Voltar </a> 
        </div>
    </body>
</html>
