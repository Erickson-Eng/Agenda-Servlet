<%--
  Created by IntelliJ IDEA.
  User: Erickson
  Date: 19/09/2021
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/editAddress" var="linkToEditAddress" />
<html>
<head>
    <title>Edição de endereço</title>
</head>
<body>
<div class="container">
    <form action="${linkToEditAddress}" method="post">
        <div>
            <h2>Endereço</h2>
            <div class="form-group">
                <label for="rua">Rua:</label>
                <input type="text" class="form-control" id="rua" name="street" value="${address.street}">
            </div>
            <div class="form-group">
                <label for="numero">Numero:</label>
                <input type="text" class="form-control" id="numero" name="number" value="${address.number}">
            </div>
            <div class="form-group">
                <label for="complemento">Complemento:</label>
                <input type="text" class="form-control" id="complemento" name="complement" value="${address.complement}" }>
            </div>
            <div class="form-group">
                <label for="bairro">Bairro:</label>
                <input type="text" class="form-control" id="bairro" name="district" value="${address.district}">
            </div>
            <div class="form-group">
                <label for="cep">Cep:</label>
                <input type="text" class="form-control" id="cep" name="cep" value="${address.cep}">
            </div>
            <div class="form-group">
                <label for="cidade">Cidade:</label>
                <input type="text" class="form-control" id="cidade" name="city" value="${address.city}">
            </div>
            <div class="form-group">
                <label for="estado">Estado:</label>
                <input type="text" class="form-control" id="estado" name="state" value="${address.state}" }>
            </div>
            <div>
                <input type="hidden" name="userId" value="${user.id}">
                <input type="hidden" name="contactId" value="${contact.id}">
                <input type="hidden" name="addressId" value="${address.id}">
                <button type="submit">Atualizar</button>
            </div>
        </div>

    </form>
</div>
</body>
</html>
