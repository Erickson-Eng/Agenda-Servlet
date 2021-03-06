<%--
  Created by IntelliJ IDEA.
  User: Erickson
  Date: 18/09/2021
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/contact" var="linkToContactDeleteServlet"/>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <link href="${pageContext.request.contextPath}/statics/css/contact.css" rel="stylesheet">

    <title>Title</title>
</head>
    <div class="container">
        <div class="text-center">
            <h2>Contatos</h2>
        </div>
        <div>
            <table class="table table-dark table-striped">
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>RG</th>
                    <th>CPF</th>
                    <th>Endereços</th>
                    <th>Editar</th>
                    <th>Deletar</th>
                </tr>
                </thead>
                <c:forEach items="${contactList}" var="contact">
                    <tbody>
                    <tr>
                        <td>${contact.name}</td>
                        <td>${contact.rg}</td>
                        <td>${contact.cpf}</td>
                        <td>
                            <button type="button" class="btn btn-link">
                                <a href="/agenda/address?contactId=${contact.id}&userId=${user.id}" >Endereços</a>
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-link">
                                <a href="/agenda/editContact?contactId=${contact.id}&userId=${user.id}" >Editar</a>
                            </button>
                        </td>
                        <td>
                            <form action="${linkToContactDeleteServlet}" method="post">
                                <input type="hidden" name="contactId" value="${contact.id}" />
                                <input type="hidden" name="userId" value="${user.id}" />
                                <button type="button" class="btn"><input type="submit" value="excluir"></button>
                            </form>
                        </td>

                    <%--                        <td><a href="/agenda/deleteContact?contactId=${contact.id}&userId=${user.id}">Deletar</a></td>--%>
                    </tbody>
                </c:forEach>
            </table>
            <div class="buttons">
                <button type="button" class="btn btn-dark"><a href="/agenda/">Sair</a></button>
                <button type="button" class="btn btn-dark"><a href="/agenda/newContact?userId=${user.id}">Adicionar</a></button>
            </div>
        </div>
    </div>
</body>
</html>
