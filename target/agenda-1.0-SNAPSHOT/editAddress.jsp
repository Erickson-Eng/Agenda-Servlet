<%--
  Created by IntelliJ IDEA.
  User: Erickson
  Date: 19/09/2021
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <title>Edição de endereço</title>
  </head>
  <body>
  <div class="container">
    <h2>Atualização de endereço</h2>
    <form action="${linkToEditAddress}" method="post">
      <div class="row mb-3">
        <label for="rua" class="col-sm-2 col-form-label">Rua:</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="rua" name="street" value="${address.street}">
        </div>
        <label for="numero" class="col-sm-2 col-form-label">Numero:</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="numero" name="number" value="${address.number}">
        </div>

        <label for="complemento" class="col-sm-2 col-form-label">Complemento:</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="complemento" name="complement" value="${address.complement}" }>
        </div>

        <label for="bairro" class="col-sm-2 col-form-label">Bairro:</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="bairro" name="district" value="${address.district}">
        </div>

        <label for="cep" class="col-sm-2 col-form-label">Cep:</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="cep" name="cep" value="${address.cep}">
        </div>

        <label for="cidade" class="col-sm-2 col-form-label">Cidade:</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="cidade" name="city" value="${address.city}">
        </div>

        <label for="estado" class="col-sm-2 col-form-label">Estado:</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="estado" name="state" value="${address.state}" }>
        </div>
        <div>
          <input type="hidden" name="userId" value="${user.id}">
          <input type="hidden" name="contactId" value="${contact.id}">
          <input type="hidden" name="addressId" value="${address.id}">
        </div>
      </div>
      <button type="submit" class="btn btn-primary">Atualizar</button>
    </form>
  </div>
  </body>
</html>
