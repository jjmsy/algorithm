package cn.xatu.servlet;

import cn.xatu.domain.Student;
import cn.xatu.service.IAdminService;
import cn.xatu.service.impl.AdimnServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/QueryAllServlet")
public class QueryAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //调用service层
        IAdminService service = new AdimnServiceimpl();
        List<Student> students = service.queryall();
        //将学生信息放到Request域
        request.setAttribute("students",students);
        //转发到adminResult.jsp
        request.getRequestDispatcher("adminResult.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
