
<%@ page import="cn.xatu.domain.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/4/24
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩管理系统</title>
</head>
<body>
<%
    List<Student> students = (List <Student>) request.getAttribute("students");
%>
<form action="UpdateServlet" method="post">
    <%
        for (Student student : students){
    %>
    学号：<input type="text" name="sno" value="<%=student.getSno()%>"><br>
    姓名：<input type="text" name="name" value="<%=student.getName()%>"><br>
    性别：<input type="text" name="sex" value="<%=student.getSex()%>"><br>
    年龄：<input type="text" name="age" value="<%=student.getAge()%>"><br>
    学院：<input type="text" name="dept" value="<%=student.getDept()%>"><br>
    密码：<input type="text" name="password" value="<%=student.getPassword()%>"><br>
    <%
        }
    %>
    <input type="submit" value="修改">
    <a href="FindStuByPageServlet"><button>返回</button></a>
</form>
</body>
</html>
