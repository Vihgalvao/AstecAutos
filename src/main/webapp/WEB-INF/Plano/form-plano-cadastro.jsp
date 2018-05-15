<%-- 
    Document   : form-plano-cadastro
    Created on : 30/04/2018, 16:18:36
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
        <div> 
            <h1>Cadastre uma Plano</h1>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/cadastro-plano"
                  method="post">
                <div>
                    Nome Plano: <input type="text" name="plano" />
                </div>
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
                <div>
                    Valor <input type="text" name="valor" />
                </div>                  
                <button type="submit">Enviar</button>
                <p>
            </form>
            <p>
                <a href= "${pageContext.request.contextPath}/HomePlanoServlet" > Voltar </a>  
                </body>
                </html>
