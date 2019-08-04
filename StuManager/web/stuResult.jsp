<%@ page import="java.util.List" %>
<%@ page import="cn.xatu.domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/4/23
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成绩</title>
</head>
<body>
<%
    List<Student> students = (List <Student>) request.getAttribute("students");

%>
<div align="center">
<table border="1" width="500" align="center">
    <tr>
        <th>课程名</th>
        <th>成绩</th>
    </tr>
    <%
        for(Student student : students){
    %>
        <tr>
            <td><%=student.getCn()%></td>
            <td><%=student.getScore()%></td>
        </tr>
    <%
        }
    %>
</table><br>
    <button><a href="index.jsp"> 返回</a></button>
</div>
</body>
</html>
