<%--
  Created by IntelliJ IDEA.
  User: Erickson
  Date: 19/09/2021
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/editContact" var="linkToEditContact"/>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Edição de contato</title>
</head>
<body>
    <div class="container">
        <h2>Contato</h2>
        <form action="${linkToEditContact}" method="post">
            <div class="row mb-3">
                <label for="usr" class="col-sm-2 col-form-label">Nome:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="usr" name="name" value="${contact.name}">
                </div>
                <label for="rg" class="col-sm-2 col-form-label">RG:</label>
                <div c class="col-sm-4">
                    <input type="text" class="form-control" id="rg" name="rg" value="${contact.rg}">
                </div>
                <label for="cpf" class="col-sm-2 col-form-label">CPF: </label>
                <div  class="col-sm-4">
                    <input type="text" class="form-control" id="cpf" name="cpf" value="${contact.cpf}">
                    <input type="hidden" class="form-control" id="contactId" name="contactId" value="${contact.id}">
                    <input type="hidden" class="form-control" id="userId" name="userId" value="${user.id}">
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">Atualizar</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
