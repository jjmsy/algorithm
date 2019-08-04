<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/4/23
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>学生成绩管理系统</title>
  </head>
  <body>
  <div align="center">
      <form action="" method="post">
          <h2>欢迎登陆网站主页</h2>
          <hr>
          <p>
             <h3>选择你的身份：</h3>
          </p>
          <p>用户名：<input type="text" name="username"></p>
          <p>密码：<input type="password" name="password"></p>
          <br>
          <a href="Stulogin.jsp">
              学生
          </a>&nbsp&nbsp
          <a href="FindStuByPageServlet">
              管理员
          </a>
          <%--<input type="submit" value="登陆"/>--%>
      </form>
  </div>
  </body>
</html>
