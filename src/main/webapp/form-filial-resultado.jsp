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
                    Nome Filial: <input type="text" name="nome" value= "${pessoaAtualizada.nomeUnidade}" />
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
                <button type="submit">Enviar</button>
            </form>
            <p> 
                <a href= "http://localhost:8080/agendaweb-1.0-SNAPSHOT/Filial.jsp" > Voltar </a> 
        </div>
    </body>
</html>
