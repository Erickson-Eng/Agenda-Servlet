<%--
  Created by IntelliJ IDEA.
  User: Erickson
  Date: 18/09/2021
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
    <div class="container">
        <h2>Lista de endereços cadastrados</h2>
        <a href="/agenda/newContact?userId=${user.id}">Adicionar</a>
        <c:forEach items="${contactList}" var="contact">
            <li>
                    ${contact.name} - ${contact.rg} - ${contact.cpf}
            </li>
        </c:forEach>
    </div>

</body>
</html>
