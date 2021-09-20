<%--
  Created by IntelliJ IDEA.
  User: Erickson
  Date: 15/09/2021
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/index" var="linkToLogin" />

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <link href="${pageContext.request.contextPath}/statics/css/index.css" rel="stylesheet">
    <title>Login</title>
</head>
<body>
    <div class="text-center">
        <h2>Agenda de contatos</h2>
    </div>
    <div class="container text-center">
        <form action="${linkToLogin}" method="post">
            <div class="row mb-3">
                <label for="mail" class="col-sm-2 col-form-label">Login:</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="mail" name="login" placeholder="Insira o email">
                </div>
                <label for="pwd" class="col-sm-2 col-form-label">Password: </label>
                <div class="col-md-10">
                    <input type="password" class="form-control" id="pwd" name="password" placeholder="Insira a senha">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
            <button type="submit" class="btn" >
                <a href="${pageContext.request.contextPath}/register" class="link">Registrar</a>
            </button>
        </form>
    </div>
</body>
</html>
