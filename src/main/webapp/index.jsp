<%-- 
    Document   : index
    Created on : 15/05/2018, 14:13:24
    Author     : victor.galvao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Locadora de Veiculos</h1>
        <form action="${pageContext.request.contextPath}/Autenticar"
              method="post">

            <div>
                Login: <input type="text" name="login" />
            </div>
            <div>
                Senha: <input type="password" name="senha" />
            </div>
            <div>
                <button type="submit">Enviar</button>
            </div>
        </form>
    </body>
</html>
