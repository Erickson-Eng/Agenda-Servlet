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
    <title>Title</title>
</head>
<body>
    <h1> Edição de contato</h1>
    <div class="container">
        <form action="${linkToEditContact}" method="post">
            <div>
                <h2>Contato</h2>
                <div class="form-group">
                    <label for="usr">Nome:</label>
                    <input type="text" class="form-control" id="usr" name="name" value="${contact.name}">
                </div>
                <div class="form-group">
                    <label for="rg">RG:</label>
                    <input type="text" class="form-control" id="rg" name="rg" value="${contact.rg}">
                </div>
                <div class="form-group">
                    <label for="cpf">CPF: </label>
                    <input type="text" class="form-control" id="cpf" name="cpf" value="${contact.cpf}">
                    <input type="hidden" class="form-control" id="contactId" name="contactId" value="${contact.id}">
                    <input type="hidden" class="form-control" id="userId" name="userId" value="${user.id}">
                </div>
                <div>
                    <button type="submit">Atualizar</button>
                </div>

            </div>
        </form>
    </div>
</body>
</html>
