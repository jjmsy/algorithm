<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/4/24
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="AddServlet" method="post">
    学号：<input type="text" name="sno" placeholder="学号"><br>
    姓名：<input type="text" name="name" placeholder="姓名"><br>
    性别：<input type="text" name="sex" placeholder="性别"><br>
    年龄：<input type="text" name="age" placeholder="0"><br>
    学院：<input type="text" name="dept" placeholder="学院"><br>
    密码：<input type="text" name="password" placeholder="密码"><br>
    <input type="submit" value="增加">
</form>
<a href="FindStuByPageServlet"><button>取消</button></a>
</body>
</html>
