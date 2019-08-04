<%@ page import="cn.xatu.domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/4/28
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Student student = (Student) request.getAttribute("student");
%>
<form>
    课程名：<input type="text" name="cn" value="<%=student.getCn()%>"><br>
    成绩：<input type="text" name="score" value="<%=student.getScore()%>"><br>
</form>
</body>
</html>
