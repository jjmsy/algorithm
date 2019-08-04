<%@ page import="cn.xatu.domain.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/4/27
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩管理系统</title>
</head>
<body>
<%
   Student student = (Student) request.getAttribute("student");
%>

<form action="UpdateScoreServlet" method="post" >
    <p>学号：<input type="text" name="sno" value="<%=student.getSno()%>" readonly><br></p>
    <p>课程号：<input type="text" name="cno" value="<%=student.getCno()%>" readonly><br></p>
    <p>成绩：<input type="text" name="score" value="<%=student.getScore()%>"><br></p>
    <input type="submit" value="修改">
    <a href="FindStuByPageServlet"><button>返回</button></a>
</form>

</body>
</html>
