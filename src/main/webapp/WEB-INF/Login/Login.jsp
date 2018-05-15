<%-- 
    Document   : Login
    Created on : 15/05/2018, 11:40:54
    Author     : victor.galvao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../includes/header.jsp" %>
        <title>Login Locadora de Veículos</title>
        <style>
            .form-signin {
                width: 330px;
                margin: 80px auto;
            }
        </style>
    </head>
    <body class="text-center">
        <div class="container">
            <form class="form-signin" method="post" action="Login">
                <h1>Locadora de Veículos ASTEC</h1><hr>
                <h3>Por favor, entre.</h3>
                <div class="form-group">
                    <label>Email:</label>
                    <%-- NO BANCO NAO PEDE EMAIL, COLOQUEI, NÃO ENTREI EM CONTATO COM O BANCO--%>
                    <input type="text" name="email" class="form-control" placeholder="email" />
                </div>
                <div class="form-group">
                    <label>Senha:</label>
                    <input type="password" name="password" class="form-control" />
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" />
                    <label>Lembrar-me meu acesso</label>
                </div>
                <button type="submit" class="btn btn-lg btn-primary btn-block">Entrar</button>
            </form>
            <span class="alert alert-danger">
                Erro
            </span>
        </div>
    </body>
</html>

