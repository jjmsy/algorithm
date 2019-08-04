<%@ page import="java.util.List" %>
<%@ page import="cn.xatu.domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/4/24
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看和修改成绩</title>
    <style>
    #up{
    width: 70px;
    height: 30px;
    background-color: darkgrey;
    }
    </style>
</head>
<body>
<%
    List<Student> students = (List <Student>) request.getAttribute("students");
%>
<div align="center">
<table border="1" width="500" align="center">
    <tr>
        <%--<th>学号</th>--%>
        <%--<th>课程号</th>--%>
        <th>课程名</th>
        <th>成绩</th>
    </tr>
    <%
        for(Student student : students){
    %>
    <tr>
        <%--<td><%=student.getSno()%></td>--%>
        <%--<td><%=student.getCno()%></td>--%>
        <td><%=student.getCn()%></td>
        <td><%=student.getScore()%></td>
        <td><a href="FindScoreServlet?sno=<%=student.getSno()%>&cno=<%=student.getCno()%>"<%=student.getSno()%><%=student.getCno()%>>
            <button id="up">修改</button>
        </a>
                <%
            }
        %>
    </tr>
</table><br>
<a href="FindStuByPageServlet">
    <button id="up">返回</button>
</a>
</div>
</body>
</html>
