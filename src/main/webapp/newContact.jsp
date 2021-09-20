<%--
  Created by IntelliJ IDEA.
  User: Erickson
  Date: 18/09/2021
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/newContact" var="linkToNewContact" />

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <link href="${pageContext.request.contextPath}/statics/css/newContact.css" rel="stylesheet" type="text/css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="${linkToNewContact}" method="post">
        <h2>Contato</h2>
        <div class="row mb-3">
            <label for="usr" class="col-sm-2 col-form-label">Nome:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="usr" name="name">
            </div>
            <label for="rg" class="col-sm-2 col-form-label">RG:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="rg" name="rg">
            </div>
            <label for="cpf" class="col-sm-2 col-form-label">CPF: </label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="cpf" name="cpf">
            </div>
        </div>
        <h2>Endereço</h2>
        <div class="row mb-3">
            <label for="rua" class="col-sm-2 col-form-label">Rua:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="rua" name="street">
            </div>
            <label for="numero" class="col-sm-2 col-form-label">Numero:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="numero" name="number">
            </div>
            <label for="complemento" class="col-sm-2 col-form-label">Complemento:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="complemento" name="complement">
            </div>

            <label for="bairro" class="col-sm-2 col-form-label">Bairro:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="bairro" name="district">
            </div>

            <label for="cep" class="col-sm-2 col-form-label">Cep:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="cep" name="cep">
            </div>

            <label for="cidade" class="col-sm-2 col-form-label">Cidade:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="cidade" name="city">
            </div>

            <label for="estado" class="col-sm-2 col-form-label">Estado:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="estado" name="state">
            </div>
            <div>
                <input type="hidden" name="userId" value="${user.id}">
            </div>
        </div>
        <div id="buttonsGroup">
            <button type="submit" class="btn btn-primary">Registrar</button>
            <button type="button" class="btn">
                <a href="/agenda/contact?userId=${user.id}">Voltar</a>
            </button>
        </div>
    </form>

</div>
</body>
</html>
