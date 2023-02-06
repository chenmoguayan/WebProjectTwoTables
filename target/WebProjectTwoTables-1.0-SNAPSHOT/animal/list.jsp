<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/1
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td></td>
            <td>名称</td>
            <td>年龄</td>
            <td>性别</td>
            <td>科目</td>
            <td>操作 | 添加</td>
        </tr>
        <c:forEach items="${list}" var="a">
            <tr>
                <td></td>
                <td>${a.name}</td>
                <td>${a.age}</td>
                <td>${a.sex}</td>
                <td>${a.type.name}</td>
                <td>
                    <a>修改</a>
                    <a>删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
