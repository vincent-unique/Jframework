<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2018/1/20
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h2>${requestScope.message}</h2>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form acceptCharset="UTF-8" action="register" method="post">
    <table>
        <tr>
            <td>姓名：</td>
            <td>
                <form:input path="username"/>
            </td>
        </tr>

        <tr>
            <td>性别：</td>
            <td>
                <form:input path="sex"/>
            </td>
        </tr>

        <tr>
            <td>年龄：</td>
            <td>
                <form:input path="age"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
