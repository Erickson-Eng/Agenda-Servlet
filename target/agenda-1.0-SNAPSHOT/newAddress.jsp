<%--
  Created by IntelliJ IDEA.
  User: Erickson
  Date: 19/09/2021
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<h2> Cadastro de novo endereço </h2>
<div class="container">
    <form action="${linkToNewAddress}" method="post">
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
            <div class="col-sm-6">
                <input type="text" class="form-control" id="cidade" name="city">
            </div>

            <label for="estado"class="col-sm-2 col-form-label">Estado:</label>
            <div class="col-sm-2" >
                <input type="text" class="form-control" id="estado" name="state">
            </div>
            <div>
                <input type="hidden" name="userId" value="${user.id}">
                <input type="hidden" name="contactId" value="${contact.id}">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</div>
</body>
</html>
