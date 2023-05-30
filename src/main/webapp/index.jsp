<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>index</title>
    </head>
    <body>
        <h3>平台总交易额：${turnover}</h3>
        <hr>
        <c:forEach items="${allProducts}" var="product">
            ${product}<br>
        </c:forEach>
        <hr>
        <h3>根据产品名称查询</h3>
        <form action="/product/name" method="get">
            请输入要查询的产品名称:<input type="text" name="name"><br>
            <input type="submit" value="Search"><br>
        </form>
        <hr>
        <a href="jsp/manager.jsp">管理员界面</a>
    </body>
</html>