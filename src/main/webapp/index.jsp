<%-- 
    Document   : index
    Created on : 15/05/2018, 14:13:24
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
        <link rel="stylesheet" href="login.css">
    </head>
    <body>

        <div class="pen-title">
            <h1>Astec Autos</h1>
        </div>
        <div class="module form-module">

            <div class="form">

            </div>
            <div class="form">
                <h2>Entre com seu Login e Senha</h2>
                <form method="POST" action="./Autenticar">
                    <input type="text" name="login" placeholder="Login"/>
                    <input type="password" name="senha" placeholder="Senha"/>
                    <button>Login</button>
                </form>
            </div>
        </div>
    </body>
</html>
