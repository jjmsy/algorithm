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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取待修改的人的学号
        String sno = request.getParameter("sno");
        //获取修改后的内容
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String dept = request.getParameter("dept");
        String password = request.getParameter("password");

        //将修改后的内容封装到实体类中
        Student student = new Student(sno,name,sex,age,dept,password);
        //调用service
        IAdminService service = new AdimnServiceimpl();
        service.updateStudent(sno,student);
        //将student存入到request
        request.setAttribute("student",student);
        //转发到FindStuByPageServlet
        request.getRequestDispatcher("FindStuByPageServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
