<%-- 
    Document   : form-pedido-atualiza
    Created on : 08/05/2018, 12:57:58
    Author     : guilherme.rocha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>atualizar um Pedido</h1>
        <div>
        <form action="${pageContext.request.contextPath}/buscar-pedido"
                  method="post">
        <div>
            Id Pedido <input type="text" name="id_pedido" />
        </div>
        <div>
            Id Plano: <input type="text" name="id_plano" />
        </div>
        <div>
            Id Carro: <input type="text" name="id_carro" />
        </div>
        <div>
            Id Funcionario: <input type="text" name="id_funcionario" />
        </div>
        <div>
            Id Filial: <input type="text" name="id_filial" />
        </div>
        <div>
            Data Locação: <input type="text" name="dtlocacao" />
        </div>
        <div>
            Data Devolução: <input type="text" name="dtdevolucao" />
        </div>
        <div>
            Dias Alugados: <input type="text" name="dias_alugados" />
        </div>
        <div>
            Valor: <input type="text" name="vlr_total" />
        </div>
        <div>
          <input type="radio" name="gender" value="atualizar" checked> Apagar<br>
          <input type="radio" name="gender" value="deletar"> Atualizar <br>
        </div>    
        <button type="submit">Salvar</button>
         </form>
            <p>
        
                <a href= "http://localhost:8080/agendaweb-1.0-SNAPSHOT/Pedido.jsp" > Voltar </a> 
        </div>
        
    </body>
</html>
