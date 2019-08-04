package cn.xatu.servlet;

import cn.xatu.domain.LimitPage;
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

@WebServlet("/FindStuByPageServlet")
//实现分页查询功能
public class FindStuByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        String pageSize = request.getParameter("pageSize");//每页显示条数
        if(pageSize ==null || "".equals(pageSize)){
            pageSize = "4";
        }
        //2.调用service查询
        IAdminService service = new AdimnServiceimpl();
        LimitPage<Student> ls = service.findStuByPage(currentPage,pageSize);
       // System.out.println(ls);
        //3.将LimitPage存入request
        request.setAttribute("ls",ls);
        //4.转发到adminResult.jsp
        request.getRequestDispatcher("/adminResult.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
