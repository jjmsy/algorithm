<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/4/23
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩管理系统</title>
</head>
<body>
<div align="center">
    <form action="StuServlet" method="post">
       <h3>查询成绩</h3>
        <p>
            学号：<input type="text" name="sno"/>
        </p>
        <input type="submit" value="查询"/>
    </form>
</div>
</body>
</html>
