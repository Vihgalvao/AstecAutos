<%-- 
    Document   : menu
    Created on : 19/05/2018, 21:29:45
    Author     : victor.galvao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Astec Autos</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            hr.style13 {
                height: 10px;
                border: 0;
                box-shadow: 0 10px 10px -10px #8c8b8b inset;
            }  

            .navbar {
                margin-bottom: 0;
                border-radius: 0;
                width: 100%;
            }

            /* Add a gray background color and some padding to the footer */
            footer {
                background-color: #f2f2f2;
                padding: 25px;
                clear: both;
                position: relative;
                z-index: 10;
                height: 3em;
                margin-top: -3em;
            }
        </style> 
    </head>
    <style>
        hr.style13 {
            height: 10px;
            border: 0;
            box-shadow: 0 10px 10px -10px #8c8b8b inset;
        }  

        .navbar {
            margin-bottom: 0;
            border-radius: 0;
            width: 100%;
        }

        /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #f2f2f2;
            padding: 25px;
            clear: both;
            position: relative;
            z-index: 10;
            height: 3em;
            margin-top: -3em;
        }
    </style> 
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/HomeServlet">AstecAutos</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Carros<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-carro"> Cadastrar Carros </a></li>
                            <li><a href="${pageContext.request.contextPath}/ListarCarrosServlet"> Listar Carros </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Funcionarios<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-funcionario"> Cadastrar Funcionarios </a></li>
                            <li><a href="${pageContext.request.contextPath}/ListarFuncionarioServlet"> Listar Funcionarios </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Clientes<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-cliente"> Cadastrar Clientes </a></li>
                            <li><a href="${pageContext.request.contextPath}/ListarClientesServlet"> Listar Clientes </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Filiais<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-filial"> Cadastrar Filiais </a></li>
                            <li><a href="${pageContext.request.contextPath}/ListarFiliaisServlet"> Listar Filiais </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Planos<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-plano"> Cadastrar Planos </a></li>
                            <li><a href="${pageContext.request.contextPath}/ListarPlanosServlet"> Listar Planos </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Pedido<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/HomePedidoServlet"> Novo Pedido </a></li>
                            <li><a href="${pageContext.request.contextPath}/ListarPedidosServlet"> Listar Pedidos </a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/Sair"><span class="glyphicon glyphicon-log-out"></span> Sair </a></li>

            </div>
        </nav>                 
    </body>
</html>
