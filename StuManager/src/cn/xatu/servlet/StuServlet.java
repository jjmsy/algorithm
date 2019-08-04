package cn.xatu.servlet;

import cn.xatu.domain.Student;
import cn.xatu.service.IStuService;
import cn.xatu.service.impl.StuServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StuServlet")
public class StuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String sno = request.getParameter("sno");
        String password = request.getParameter("password");
        IStuService service = new StuServiceimpl();
        List <Student> students = service.QueryScore(sno);

        Student student = new Student();

        request.setAttribute("students",students);
        request.getRequestDispatcher("stuResult.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
