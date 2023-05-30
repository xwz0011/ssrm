<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>result</title>
</head>
<body>
    <h3>对产品${name}的查询结果</h3>
    <hr>
    <c:forEach items="${allProducts}" var="product">
        ${product}<br>
    </c:forEach>
</body>