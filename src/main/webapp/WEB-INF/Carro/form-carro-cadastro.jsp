<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div> 
            <h1>Cadastre um Carro</h1>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/cadastro-carro"
                  method="post">
                <div>
                    Nome Carro: <input type="text" name="carro" />
                </div>
                <div>
                    Fabricante: <input type="text" name="fabricante" />
                </div>
                <div>
                    Cor: <input type="text" name="cor" />
                </div>  
                <div>
                    Ano: <input type="text" name="ano" />
                </div>  
                <div>
                    Valor Carro (Fipe): <input type="text" name="valor"/>
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
                
                
                <button type="submit">Enviar</button>
                <p>
            </form>
                  <p>
                  <a href= "${pageContext.request.contextPath}/HomeCarroServlet" > Voltar </a>      
                 
                  
        </div>
    </body>
</html>
