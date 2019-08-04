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

@WebServlet("/UpdateScoreServlet")
public class UpdateScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取待修改的人的学号和课程号
        String sno = request.getParameter("sno");
        String cno = request.getParameter("cno");
        //获取修改后的内容
        String cn = request.getParameter("cn");
        int score = Integer.parseInt(request.getParameter("score"));
        //将修改后的内容封装到实体类中
        Student student = new Student(score,sno,cno);
        //调用service层
        IAdminService service = new AdimnServiceimpl();
        boolean result = service.updateScore(sno, student);
        //将数据发送到request域
        request.setAttribute("student",student);
        //转发到updateScore.jsp
       // request.getRequestDispatcher("FindStuByPageServlet").forward(request,response);
        if(result){
            //response.getWriter().print("<script type='text/javascript'>alert('修改成功');</script>");
            response.sendRedirect("FindStuByPageServlet");//修改完毕后再跳回查询所有
        }else {
                response.getWriter().print("修改失败！");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
