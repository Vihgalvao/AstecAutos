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
            <form action="${pageContext.request.contextPath}/buscar-filial"
                  method="post">
                <div>
                    Id Filial: <input type="text" name="id" />
                </div>
                <div>
                    Nome Filial: <input type="text" name="NomeUnidade" />
                </div>
                <div>
                    Nome Rua: <input type="text" name="Rua" />
                </div>
                <div>
                    Numero: <input type="text" name="Numero" />
                </div>  
                <div>
                    CEP <input type="text" name="Cep" />
                </div>   
                <div>
                    Telefone Filial (Apenas Numeros): <input type="text" name="Telefone"/>
                </div>
                <div>
                    Gerente: <input type="text" name="Gerente"/>
                </div>
                <div>
                  <input type="radio" name="gender" value="atualizar" checked> Apagar<br>
                  <input type="radio" name="gender" value="deletar"> Atualizar <br>
                </div>    
                <button type="submit">Salvar</button>
            </form>
            <p>
                <a href= "${pageContext.request.contextPath}/HomeFilialServlet" > Voltar </a> 
        </div>
    </body>
</html>
