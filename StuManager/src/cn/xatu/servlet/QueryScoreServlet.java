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
import java.util.List;

@WebServlet("/QueryScoreServlet")
public class QueryScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //调用service层
        String sno = request.getParameter("sno");
        String cno = request.getParameter("cno");
        IAdminService service = new AdimnServiceimpl();
        List <Student> students = service.queryScore(sno);
        //将查询到的信息放到request域
        request.setAttribute("students",students);
        request.setAttribute("sno",sno);
        request.setAttribute("cno",cno);
        request.getRequestDispatcher("Score.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
