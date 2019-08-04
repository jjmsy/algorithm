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

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //接收jsp页面传来的参数
        String sno = request.getParameter("sno");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String dept = request.getParameter("dept");
        String password = request.getParameter("password");
        Student student = new Student(sno,name,sex,age,dept,password);
        //调用Service层
        IAdminService service = new AdimnServiceimpl();
        boolean result = service.addStudent(student);
        if(result){
            request.getRequestDispatcher("FindStuByPageServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
