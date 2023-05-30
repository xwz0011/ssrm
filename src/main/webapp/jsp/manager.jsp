<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>manager</title>
</head>
<body>
    <h3>金融产品列表</h3>
    <hr>
    <c:forEach items="${allProducts}" var="product">
        ${product}<br>
    </c:forEach>
    <hr>
    <h3>新增产品</h3>
    <form action="/product" method="post">
        name:<input type="text" name="name"> <br>
        rate:<input type="text" name="rate"> <br>
        amount:<input type="text" name="amount"> <br>
        raised:<input type="text" name="raised"> <br>
        cycle:<input type="text" name="cycle"> <br>
        endTime:<input type="text" name="endTime"> <br>
        <input type="submit" value="添加">
    </form>
    <hr>
    <a href="/">返回首页</a>
</body>
</html>