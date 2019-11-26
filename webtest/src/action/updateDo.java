package action;

import entity.User;
import impdao.ImpUserDao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginDo
 */
@WebServlet("/updateDo")
public class updateDo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateDo() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //首先取出用户名 密码
        //解决乱码
        response.setContentType("text/html;charset=utf-8");

        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

//        System.out.println(name+pwd);

//        向数据库插入用户名和密码
        User u= new User(name,pwd);
        ImpUserDao imp=new ImpUserDao();
        boolean f = imp.updateUser(u,id);


        if(f) {
            //定向跳到成功页面
            response.sendRedirect("success.jsp");
        }else {
            response.sendRedirect("error.jsp");
        }


    }

}