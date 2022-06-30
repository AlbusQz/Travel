package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.*;
import dao.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		try {
			
			req.setCharacterEncoding("UTF-8");
			resp.setHeader("content-type","text/html;charset=UTF-8");
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter outs=resp.getWriter();
			String name=req.getParameter("name");
			
			String password=req.getParameter("password");
			String code = req.getParameter("code");
			resp.setCharacterEncoding("UTF-8");
			if(!code.equals(session.getAttribute("Code")))
			{
				outs.write("<script language='javascript'>alert('验证码错误!');charset=\"gb2312\";window.location.href='/Travel_Web/login.jsp';</script>");
			}
			
			if(!name.matches("[0-9]+"))
			{
				outs.write("<script language='javascript'>alert('账号格式错误!');charset=\"gb2312\";window.location.href='/Travel_Web/login.jsp';</script>");
			}
			long id = Long.parseLong(name);
			
			session.setAttribute("userid2short", 0);
			session.setAttribute("password2short", 0);
			if(name.length()<6||name.length()>16)
			{
				outs.write("<script language='javascript'>alert('输入用户名过短!');charset=\"gb2312\";window.location.href='/Travel_Web/login.jsp';</script>");
			}
		
			if(password.length()<6)
			{
				outs.write("<script language='javascript'>alert('输入密码过短!');charset=\"gb2312\";window.location.href='/Travel_Web/login.jsp';</script>");
			}
		
			
			Customer user = null;
			customerdao cd = new customerdao();
			user = cd.findCustomer(id);
			if(user==null)
				user=cd.findCustomerbytel(id);
			//UserBiz bn=new UserBiz();
			//user=bn.loginIn(name, password);
			if(user==null)
			{
				
				outs.write("<script language='javascript'>alert('该账户不存在！');window.location.href='/Travel_Web/login.jsp';</script>");
			}
			else
			if(user.getPassword().equals(password))
			{
				session.setAttribute("user", user);
				session.setAttribute("havelogin", true);
				//session.setAttribute("userid", user.getRole());
				outs.write("<script charset='utf-8' language='javascript'>alert('登录成功!');</script>");
				req.getRequestDispatcher("/index.html").forward(req, resp);
			}
			else
			{
				outs.write("<script language='javascript'>alert('密码错误!');charset=\"gb2312\";window.location.href='/Travel_Web/login.jsp';</script>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String error =e.toString();
			session.setAttribute("error", error);
			try {
				PrintWriter outs=resp.getWriter();
				outs.write(error);
				//req.getRequestDispatcher("/error.jsp").forward(req, resp);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
	}

}
