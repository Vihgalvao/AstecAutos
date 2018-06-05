<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Carro</title>
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
            <h1>Atualizar um Carro</h1>
        </div>
        <p>
        <hr class="style13">    
        <div>
            <form action="${pageContext.request.contextPath}/AtualizarCarro"
                  method="post">

                <div class="form-row" >
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-2">
                            <label for="inputEmail4">Id Carro</label>
                            <input type="text" class="form-control" placeholder="Modelo" name="idcarro" value= "${carroAtualizada.idcarro}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputEmail4">Nome Carro</label>
                            <input type="text" class="form-control" placeholder="Modelo" name="carro" value= "${carroAtualizada.carro}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputPassword4">Fabricante</label>
                            <input type="text" class="form-control" placeholder="Fabricante" name="fabricante"  value= "${carroAtualizada.fabricante}">
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-6">
                            <label for="inputAddress">Cor</label>
                            <input type="text" class="form-control" placeholder="Cor do Carro" name="cor" value= "${carroAtualizada.cor}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Ano</label>
                            <input type="number" class="form-control" placeholder="Ano Fabricação" name="ano" value= "${carroAtualizada.ano}">
                        </div>
                    </div>
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-6">
                            <label for="inputAddress">Valor Atual (Fipe)</label>
                            <input type="number" class="form-control" placeholder="Preço Atual" name="valor" value= "${carroAtualizada.valor}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Categoria </label>
                            <select class="form-control" name="class"id="categoria" >
                                <option value="1">Hatch</option>
                                <option value="2">Sedan</option>
                                <option value="3">SUV</option>
                                <option value="4">Picapes</option>
                                <option value="5">Esportivos</option>
                                <option value="6">Vans</option>
                            </select>
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

                    <div class="form-group row">
                        <div class="col-sm-8">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                        </div>
                    </div>

                </div>
            </form>
            <p> 
                <a href= "${pageContext.request.contextPath}/HomeCarroServlet" > Voltar </a> 

                <script>

                    var classe = "${carroAtualizada.idclassificacao}";
                    var element = document.querySelector('#categoria');
                    element.selectedIndex = classe;

                </script>   
        </div>
    </body>
</html>
