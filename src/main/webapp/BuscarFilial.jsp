<%-- 
    Document   : BuscarUnidade
    Created on : 17/04/2018, 12:43:38
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
        <form action="${pageContext.request.contextPath}/buscar-filial"
              method="post">
            <div>
                Digite o Id da filial: <input type="text" name="idfilial" />
            </div>
            <button type="submit">Pesquisar</button>
            <p>
        </form>

        <p>
            <a href= "http://localhost:8080/agendaweb-1.0-SNAPSHOT/Filial.jsp" > Voltar </a>    
    </body>
</html>
