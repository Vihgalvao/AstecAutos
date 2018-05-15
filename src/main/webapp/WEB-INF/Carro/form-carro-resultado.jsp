<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div> 
            <h1>Atualizar um Carro</h1>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/AtualizarCarro"
                  method="post">
                <div>
                    Id carro: <input type="text" name="idcarro" value= "${carroAtualizada.idcarro}"/>
                </div>
                <div>
                    Nome Carro: <input type="text" name="carro" value= "${carroAtualizada.carro}"/>
                </div>
                <div>
                    Fabricante: <input type="text" name="fabricante" value= "${carroAtualizada.fabricante}"/>
                </div>
                <div>
                    Cor: <input type="text" name="cor" value= "${carroAtualizada.cor}"/>
                </div>  
                <div>
                    Ano: <input type="text" name="ano" value= "${carroAtualizada.ano}"/>
                </div>  
                <div>
                    Valor Carro (Fipe): <input type="text" name="valor" value= "${carroAtualizada.valor}"/>
                </div>
                <div>
                    Classificação:
                    <select name="class" id="categoria">
                        <option value="1">Hatch</option>
                        <option value="2">Sedan</option>
                        <option value="3">SUV</option>
                        <option value="4">Picapes</option>
                        <option value="5">Esportivos</option>
                        <option value="6">Vans</option>
                    </select>
                </div>

                <div>
                    <input type="radio" name="metodo" value="atualizar"> Atualizar <br>
                    <input type="radio" name="metodo" value="deletar" checked> Deletar <br>
                </div> 

                <button type="submit">Salvar</button>
            </form>
            <p> 
                <a href= "${pageContext.request.contextPath}/HomeCarroServlet" > Voltar </a> 

                <script>

                    var classe = "${carroAtualizada.idclassificacao}"
                    var element = document.querySelector('#categoria')
                    element.selectedIndex = classe;

                </script>   
        </div>
    </body>
</html>
