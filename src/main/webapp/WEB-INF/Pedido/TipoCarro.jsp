<%-- 
    Document   : TipoCarro
    Created on : 10/05/2018, 16:23:32
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
        <form action="${pageContext.request.contextPath}/CarregaOp"
              method="post">
            
                <div>
                Classificação:
                <select name="class">
                    <option value="1">Hatch</option>
                    <option value="2">Sedan</option>
                    <option value="3">SUV</option>
                    <option value="4">Picapes</option>
                    <option value="5">Esportivos</option>
                    <option value="6">Vans</option>
                </select>
                </div>

            <button type="submit">Enviar</button>
            <p>
        </form>
    </body>
</html>
