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

@WebServlet("/FindScoreServlet")
public class FindScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在更改之前先进行用户回显操作
        request.setCharacterEncoding("utf-8");
        //调用service
        IAdminService service = new AdimnServiceimpl();
        String sno = request.getParameter("sno");
        String cno = request.getParameter("cno");
        Student student = service.findScore(sno,cno);
        request.setAttribute("student",student);
        request.setAttribute("sno",sno);
        request.getRequestDispatcher("updateScore.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
