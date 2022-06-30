package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.customerdao;
import dao.historydao;
import entity.Customer;
import entity.Line;
import entity.Ticket;

/**
 * Servlet implementation class buyTicketServlet
 */
@WebServlet("/buyLineServlet")
public class buyLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyLineServlet() {
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
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		PrintWriter outs=resp.getWriter();
		
		
		
		try {
			Customer user = (Customer)session.getAttribute("user");
			historydao hd = new historydao();
			Line line =(Line)session.getAttribute("lineshow");
			hd.buyLine(line, user);
			outs.write("<script language='javascript'>alert('购买成功！');window.location.href='/Travel_Web/lineshow.jsp';</script>");}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				outs.write("<script language='javascript'>alert('购买失败！');window.location.href='/Travel_Web/lineshow.jsp';</script>");
			}
		
	}

}
