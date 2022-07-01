package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.sendTool;

/**
 * Servlet implementation class sendText
 */
@WebServlet("/sendText")
public class sendText extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendText() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int code= (int) (1000+Math.random()*(9999-1000+1));
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter outs=resp.getWriter();
		HttpSession session = req.getSession();
		session.setAttribute("code", code);
		String phone=req.getParameter("phone");
		if(phone!=null)
		{
			sendTool.send(phone, String.valueOf(code));
			session.setAttribute("phone", phone);
		}
		else
		{
			sendTool.send("17685515217", String.valueOf(code));
			session.setAttribute("phone","17685515217");
		}
		outs.write("<script charset='utf-8' language='javascript'>alert('发送成功!');</script>");
		req.getRequestDispatcher("/register2.jsp").forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
