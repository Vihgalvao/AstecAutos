<%-- 
    Document   : HomePage
    Created on : 15/05/2018, 14:23:33
    Author     : victor.galvao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
            }

            /* Add a gray background color and some padding to the footer */
            footer {
                background-color: #f2f2f2;
                padding: 25px;
            }


        </style>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>


        <div class="jumbotron">
            <div class="container text-center">
                <h1>Astec Autos</h1>      
                <p>Alugue carros de todos os modelos e potências, seja para viagens ou para trabalho. Temos filiais nas maiores Capitais do País, confira nosso site.</p>
            </div>
        </div>

        <div class="container-fluid bg-3 text-center">    
            <h3>Abaixo nossos modelos 2018!</h3><br>
            <div class="row">
                <div class="col-sm-3">
                    <b><p>Fox Trendline 1.6 2018</p></b>
                    <img src="./img/fox2018.jpg" class="img-responsive" style="width:100%" alt="Image">
                </div>
                <div class="col-sm-3"> 
                    <b><p>HB20 1.6 Comfort Plus automático</p></b>
                    <img src="./img/hb202018.jpg" style="width:100%" alt="Image">
                </div>
                <div class="col-sm-3"> 
                    <b><p>Honda HRV EX-L CVT</p></b>
                    <img src="./img/hrv2018.jpg" class="img-responsive" style="width:100%" alt="Image">
                </div>
                <div class="col-sm-3">
                    <b><p>Onix Effect 2018</p></b>
                    <img src="./img/onix2018.jpg" class="img-responsive" style="width:100%" alt="Image">
                </div>
            </div>
        </div><br>


        <footer class="container-fluid text-center">
            <p>Astec Autos Locação de Veiculos - Todos os Direitos Reservador - 2018</p>

        </footer>
    </body>


</html>
