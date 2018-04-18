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
                <button type="submit">Enviar</button>
            </form>
            <p>
                <a href= "http://localhost:8080/agendaweb-1.0-SNAPSHOT/Filial.jsp" > Voltar </a> 
        </div>
    </body>
</html>
