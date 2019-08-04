<%@ page import="cn.xatu.domain.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.xatu.domain.LimitPage" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/4/24
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生管理系统</title>
    <style>
        div{
            font-size: 17px;
            text-align: center;
            line-height: 10px;
            /*背景*/
            /*background: darkgrey;*/

        }
       #add{
            width: 150px;
            height: 40px;
            background-color: darkgrey;
        }
        #up{
            width: 70px;
            height: 40px;
            background-color: darkgrey;
        }
        #page{
            width: 30px;
            height: 30px;
            background-color: cornsilk;
        }
    </style>
    <%--<style>--%>
        <%--#main {position: absolute;width:1000px;height:400px;left:50%;top:50%;--%>
            <%--margin-left:-400px;margin-top:-200px;border:1px;background: darkgray; text-align: center}--%>
    <%--</style>--%>
    <script>
        // window.onload = function () {
        // function deleteStu(id) {
        //     //用户安全提示
        //     if(confirm("您确定要删除吗？")){
        //         //访问路径
        //         location.href="DelateServlet?sno="+id;
        //     }
        // }
        // }
    </script>
</head>
<body>
<%
  // List<Student> students = (List <Student>) request.getAttribute("students");
    LimitPage<Student> ls = (LimitPage <Student>) request.getAttribute("ls");
%>

<div>
    <br><br><br>
    <h2>学生成绩管理系统</h2><hr><br>
<table border="10" width="700" align="center">
    <tr bgcolor="#696969">
        <th><label>学号</label></th>
        <th><label>姓名</label></th>
        <th><label>性别</label></th>
        <th><label>年龄</label></th>
        <th><label>学院</label></th>
        <th><label>密码</label></th>
        <th><label>成绩</label></th>
        <th><label>其他操作</label></th>
    </tr>
    <%
        for(Student student : ls.getList()){
    %>
    <tr bgcolor="#a9a9a9" align="center">
        <td><%=student.getSno()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getSex()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getDept()%></td>
        <td><%=student.getPassword()%></td>
        <td><a href="QueryScoreServlet?sno=<%=student.getSno()%>"><button id="up">查看成绩</button></a></td>
        <td><a href="FindServlet?sno=<%=student.getSno()%>"><button id="up">修改</button></a>
            <a href="DelateServlet?sno=<%=student.getSno()%>"><button id="up">删除</button></a>
                </td>
        <%--
        javascript:deleteStu(<%=student.getSno()%>--%>
    </tr>
    <%
        }
    %>
</table><br>
</div>
<div>
<a href="add.jsp" ><button id="add">添加学生</button></a><br>
</div><br>
<div>
    <a href="FindStuByPageServlet?currentPage=1">首页</a>
    <a href="FindStuByPageServlet?currentPage=<%=ls.getCurrentPage()-1%>">上一页</a>

        <c:forEach begin="1" end="${ls.totalPage}" var="i">
            <a href="${pageContext.request.contextPath}/FindStuByPageServlet?currentPage=${i}&pageSize=4"><button id="page">${i}</button></a>
        </c:forEach>
    <a href="FindStuByPageServlet?currentPage=<%=ls.getCurrentPage()+1%>">下一页</a>
    <a href="FindStuByPageServlet?currentPage=<%=ls.getTotalPage()%> ">尾页</a>
</div>

</body>
</html>
