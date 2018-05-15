<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div> 
            <h1>Cadastre uma Filial</h1>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/cadastro-filial"
                  method="post">
                <div>
                    Nome Filial: <input type="text" name="nome" />
                </div>
                <div>
                    Nome Rua: <input type="text" name="rua" />
                </div>
                <div>
                    Numero: <input type="text" name="numero" />
                </div>  
                <div>
                    CEP <input type="text" name="cep" />
                </div>   
                <div>
                    Telefone Filial (Apenas Numeros): <input type="text" name="telefone"/>
                </div>
                <div>
                    Gerente: <input type="text" name="gerente"/>
                </div>
                
                <button type="submit">Enviar</button>
                <p>
            </form>
                  <p>
                  <a href= "${pageContext.request.contextPath}/HomeFilialServlet" > Voltar </a>   
                 
                  
        </div>
    </body>
</html>
