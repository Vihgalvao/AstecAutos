<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>   
    </head>
    <body>
        <div> 
            <h1>Atualizar um Plano</h1>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/AtualizarPlano"
                  method="post">
                
                 <div>
                    Id Plano: <input type="text" name="id_plano" value= "${planoAtualizada.idplano}"/>
                </div>

                <div>
                    Nome Plano: <input type="text" name="nome" value= "${planoAtualizada.plano}" />
                </div>
                <div> Classificação: 
                <select name="class" id="categoria" >     
                    <option value="0" >Selecione</option>
                    <option value="1" >Hatch</option>
                    <option value="2" >Sedan</option>
                    <option value="3" >SUV</option>
                    <option value="4" >Picapes</option>
                    <option value="5" >Esportivos</option>
                    <option value="6" >Vans</option>
                </select>
                </div>

                <div>
                    Valor: <input type="text" name="numero" value= "${planoAtualizada.valor}"/>
                </div>  
                <div>
                  <input type="radio" name="metodo" value="atualizar"> Atualizar <br>
                  <input type="radio" name="metodo" value="deletar" checked> Deletar <br>
                </div> 
                <button type="submit">Salvar</button>
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
