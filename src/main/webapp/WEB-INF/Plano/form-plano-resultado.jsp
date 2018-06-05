<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>   
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div> 
            <h1>Atualizar um Plano</h1>
        </div>
        <p>
        <hr class="style13">  
        <div>
            <form action="${pageContext.request.contextPath}/AtualizarPlano"
                  method="post">

                <div class="form-group col-md-8" >
                    <div class="form-row col-md-2">
                        <label for="inputAddress">id:</label>
                        <input type="text" class="form-control" placeholder="Nome" name="id_plano" value= "${planoAtualizada.idplano}">
                    </div>
                    <div class="form-row col-md-2">
                        <label for="inputAddress">Nome Plano:</label>
                        <input type="text" class="form-control" placeholder="Nome" name="plano" value= "${planoAtualizada.plano}">
                    </div>
                    <div class="form-row col-md-4">
                        <label for="inputAddress">Categoria</label>
                        <select class="form-control" name="class" id="categoria" >
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
                        <input type="number" class="form-control" placeholder="Valor Plano" name="valor" value= "${planoAtualizada.valor}">
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadioInline1" name="metodo" class="custom-control-input" value="atualizar">
                        <label class="custom-control-label" for="customRadioInline1">Atualizar</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="customRadioInline2" name="metodo" value="deletar" class="custom-control-input">
                        <label class="custom-control-label" for="customRadioInline2">Deletar</label>
                    </div>
                </div>
                <p>
                <div class="form-group row center-block">
                    <div class="col-sm-8">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </div>

            </form>
            <p> 
                <a href= "${pageContext.request.contextPath}/HomePlanoServlet" > Voltar </a>  
        </div>

        <script>

            var classe = "${planoAtualizada.idclassificacao}"
            var element = document.querySelector('#categoria')
            element.selectedIndex = classe;

        </script>              
    </body>
</html>
