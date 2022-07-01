package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.customerdao;
import entity.Customer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter outs=resp.getWriter();
		try {
			
			
			String phone=req.getParameter("phone");
			String name=req.getParameter("name");
			String password=req.getParameter("password");
			String password1=req.getParameter("password2");
			String code=req.getParameter("code");
			String codex=(String)session.getAttribute("code");
			if(!code.equals(codex))
			{
				outs.write("<script language='javascript'>alert('验证码错误!"+code+"|"+session.getAttribute("code")+"');charset=\"gb2312\";window.location.href='/Travel_Web/register.jsp';</script>");
			
			}
			if(!password.equals(password1))
			{
				outs.write("<script language='javascript'>alert('输入密码不匹配!"+password+"|"+password1+"');charset=\"gb2312\";window.location.href='/Travel_Web/register.jsp';</script>");
			}
			
			Customer user =new Customer();
			customerdao cd = new customerdao();
			user.setName(name);
			user.setPassword(password);
			BigDecimal bd = new BigDecimal(phone);
			user.setTel(bd);
			cd.addCustomer(user);
			session.setAttribute("user", user);
			session.setAttribute("havelogin", true);
			outs.write("<script language='javascript'>alert('注册成功!您的ID为"+user.getId()+"');charset=\"gb2312\";window.location.href='/Travel_Web/login.jsp';</script>");
			}catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				outs.write("<script charset='utf-8' language='javascript'>alert('出现错误!请重试');</script>");
				//req.getRequestDispatcher("/login.jsp").forward(req, resp);
				
	}
}
}
