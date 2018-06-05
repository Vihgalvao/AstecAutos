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
        <title>Cadastre um Plano</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div> 
            <h1>Cadastre um Plano</h1>
        </div>
        <p>
        <hr class="style13"> 
        <div>
            <form action="${pageContext.request.contextPath}/cadastro-plano"
                  method="post">

                <div class="form-group col-md-8" >
                    <div class="form-row col-md-4">
                        <label for="inputAddress">Nome Plano:</label>
                        <input type="text" class="form-control" placeholder="Nome" name="plano">
                    </div>
                    <div class="form-row col-md-4">
                        <label for="inputAddress">Categoria</label>
                        <select class="form-control" name="class" >
                            <option value="0">Selecione</option>
                            <option value="1">Hatch</option>
                            <option value="2">Sedan</option>
                            <option value="3">SUV</option>
                            <option value="4">Picapes</option>
                            <option value="5">Esportivos</option>
                            <option value="6">Vans</option>
                        </select>
                    </div>
                    <div class="form-row col-md-4">
                        <label for="inputAddress">Valor</label>
                        <input type="number" class="form-control" placeholder="Valor Plano" name="valor">
                    </div>
                </div>
                <p>
                <div class="form-group row center-block">
                    <div class="col-sm-8">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                    </div>
                </div>
            </form>
            <p>
                <a href= "${pageContext.request.contextPath}/HomePlanoServlet" > Voltar </a>  
                </body>
                </html>
