<%--
  Created by IntelliJ IDEA.
  User: Erickson
  Date: 19/09/2021
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/address" var="linkToDeleteAddress"/>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <link href="${pageContext.request.contextPath}/statics/css/address.css" rel="stylesheet">

    <title>Title</title>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <div id="title">
                <h2>Enderecos cadastrados </h2>
                <p> Endereços cadastrados do ${contact.name} </p>
            </div>
            <div>
                <table class="table table-dark table-striped">
                    <thead>
                    <tr>
                        <th>Rua</th>
                        <th>Numero</th>
                        <th>Complemento</th>
                        <th>Bairro</th>
                        <th>Cep</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>Editar</th>
                        <th>Deletar</th>
                    </tr>
                    </thead>
                    <c:forEach items="${addressList}" var="address">
                    <tbody>
                    <tr>
                        <td>${address.street}</td>
                        <td>${address.number} </td>
                        <td>${address.complement}</td>
                        <td>${address.district}</td>
                        <td>${address.cep}</td>
                        <td>${address.city}</td>
                        <td>${address.state}</td>
                        <td><a href="/agenda/editAddress?userId=${user.id}&contactId=${contact.id}&addressId=${address.id}">editar</a></td>
                        <td>
                            <form action="${linkToDeleteAddress}" method="post">
                                <input type="hidden" name="contactId" value="${contact.id}" />
                                <input type="hidden" name="userId" value="${user.id}" />
                                <input type="hidden" name="addressId" value="${address.id}">
                                <button type="button" class="btn"><input type="submit" value="excluir"></button>
                            </form>
                        </td>
                    </tr>
                    </tbody>
                    </c:forEach>
                </table>

            </div>

        </div>
        <div>
            <button type="button" class="btn btn-dark"><a href="/agenda/contact?userId=${user.id}">Voltar</a></button>
            <button type="button" class="btn btn-dark"><a href="/agenda/newAddress?userId=${user.id}&contactId=${contact.id}">Cadastrar</a></button>
        </div>
    </div>
</body>
</html>
