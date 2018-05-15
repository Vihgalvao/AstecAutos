<%-- 
    Document   : form-pedido-resultado
    Created on : 08/05/2018, 16:27:39
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
        <div> 
            <h1>Atualizar uma Pedido</h1>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/AtualizarPedido"
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
          <input type="radio" name="metodo" value="atualizar"> Atualizar <br>
          <input type="radio" name="metodo" value="deletar" checked> Deletar <br>
        </div>       
        <button type="submit">Salvar</button>
            </form>
            <p> 
                <a href= "http://localhost:8080/agendaweb-1.0-SNAPSHOT/PedidoInicio.jsp" > Voltar </a> 
         </div>        
    </body>
</html>
