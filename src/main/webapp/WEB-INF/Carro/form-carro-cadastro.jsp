<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Carro</title>
        <style>
            hr.style13 {
                height: 10px;
                border: 0;
                box-shadow: 0 10px 10px -10px #8c8b8b inset;
            }  
        </style> 
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div> 
            <h1>Cadastre um Carro</h1>
        </div>
        <p>
        <hr class="style13">    


        <form action="${pageContext.request.contextPath}/cadastro-carro" method="post">

            <div class="form-row" >
                <div class="form-group col-md-8" >
                    <div class="form-row col-md-4">
                        <label for="inputEmail4">Nome Carro</label>
                        <input type="text" class="form-control" placeholder="Modelo" name="carro">
                    </div>
                    <div class="form-row col-md-4">
                        <label for="inputPassword4">Fabricante</label>
                        <input type="text" class="form-control" placeholder="Fabricante" name="fabricante">
                    </div>
                </div>
                <div class="form-group col-md-8" >
                    <div class="form-row col-md-4">
                        <label for="inputAddress">Cor</label>
                        <input type="text" class="form-control" placeholder="Cor do Carro" name="cor">
                    </div>
                    <div class="form-row col-md-4">
                        <label for="inputAddress">Ano</label>
                        <input type="number" class="form-control" placeholder="Ano Fabricação" name="ano">
                    </div>
                </div>
                <div class="form-group col-md-8" >
                    <div class="form-row col-md-4">
                        <label for="inputAddress">Valor Atual (Fipe)</label>
                        <input type="number" class="form-control" placeholder="Preço Atual" name="valor">
                    </div>
                    <div class="form-row col-md-4">
                        <label for="inputAddress">Categoria </label>
                        <select class="form-control" name="class" >
                            <option value="1">Hatch</option>
                            <option value="2">Sedan</option>
                            <option value="3">SUV</option>
                            <option value="4">Picapes</option>
                            <option value="5">Esportivos</option>
                            <option value="6">Vans</option>
                        </select>
                    </div>
                </div>
                <p>

                <div class="form-group row right">
                    <div class="col-sm-8">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                    </div>
                </div>

            </div>
        </form>


        <a href= "${pageContext.request.contextPath}/HomeCarroServlet" > Voltar </a>  
        <p>
            
    </body>
</html>
