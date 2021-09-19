<%--
  Created by IntelliJ IDEA.
  User: Erickson
  Date: 19/09/2021
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/newAddress" var="linkToNewAddress" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2> Cadastro de novo endereço </h2>
    <div class="container">
        <form action="${linkToNewAddress}" method="post">
            <div>
                <h2>Endereço</h2>
                <div class="form-group">
                    <label for="rua">Rua:</label>
                    <input type="text" class="form-control" id="rua" name="street">
                </div>
                <div class="form-group">
                    <label for="numero">Numero:</label>
                    <input type="text" class="form-control" id="numero" name="number">
                </div>
                <div class="form-group">
                    <label for="complemento">Complemento:</label>
                    <input type="text" class="form-control" id="complemento" name="complement">
                </div>
                <div class="form-group">
                    <label for="bairro">Bairro:</label>
                    <input type="text" class="form-control" id="bairro" name="district">
                </div>
                <div class="form-group">
                    <label for="cep">Cep:</label>
                    <input type="text" class="form-control" id="cep" name="cep">
                </div>
                <div class="form-group">
                    <label for="cidade">Cidade:</label>
                    <input type="text" class="form-control" id="cidade" name="city">
                </div>
                <div class="form-group">
                    <label for="estado">Estado:</label>
                    <input type="text" class="form-control" id="estado" name="state">
                </div>
                <div>
                    <input type="hidden" name="userId" value="${user.id}">
                    <input type="hidden" name="contactId" value="${contact.id}">
                    <button type="submit">Cadastrar</button>
                </div>
            </div>

        </form>
    </div>
</body>
</html>
