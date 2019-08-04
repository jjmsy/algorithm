package cn.xatu.servlet;

import cn.xatu.service.IAdminService;
import cn.xatu.service.impl.AdimnServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelateServlet")
public class DelateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //接收前端传来的学号
        String sno = request.getParameter("sno");
        //调用service层
        IAdminService service = new AdimnServiceimpl();
        boolean result = service.deleteStudent(sno);
        if(result){
           // response.getWriter().print("<script type='text/javascript'>alert('删除成功！');</script>");
            request.getRequestDispatcher("FindStuByPageServlet").forward(request,response);//重新查询所有学生
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
