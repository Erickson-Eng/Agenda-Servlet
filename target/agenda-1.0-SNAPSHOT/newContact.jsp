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
    <title>Title</title>
</head>
<body>
<h1> New Contact</h1>
</body>
    <div class="container">
        <form action="${linkToNewContact}" method="post">
            <div>
                <h2>Contato</h2>
                <div class="form-group">
                    <label for="usr">Nome:</label>
                    <input type="text" class="form-control" id="usr" name="name">
                </div>
                <div class="form-group">
                    <label for="rg">RG:</label>
                    <input type="text" class="form-control" id="rg" name="rg">
                </div>
                <div class="form-group">
                    <label for="cpf">CPF: </label>
                    <input type="text" class="form-control" id="cpf" name="cpf">
                </div>
            </div>
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
                    <button type="submit">Registrar</button>
                </div>
            </div>
        </form>
        <a href="/agenda/contact?userId=${user.id}">Voltar</a>
    </div>
</html>
