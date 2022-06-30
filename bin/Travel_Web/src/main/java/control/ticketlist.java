package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.*;
import dao.*;
/**
 * Servlet implementation class ticketlist
 */
@WebServlet("/ticketlist")
public class ticketlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public int size=5;
    public ticketlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
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
		PrintWriter outs=resp.getWriter();
		HttpSession session = req.getSession();
		resp.setCharacterEncoding("UTF-8");
		ticketdao td = new ticketdao();
		int start;
		if(session.getAttribute("ticketstart")!=null)
		{
			start=(int) session.getAttribute("ticketstart");
			
		}
		else
		{
			start=0;
			session.setAttribute("ticketstart", start);
		}
		int pic=0;
		if(session.getAttribute("ticketpic")!=null)
		{
			start=(int) session.getAttribute("ticketpic");
			
		}
		else
		{
			pic=0;
			session.setAttribute("ticketpic", pic);
		}
		List<Ticket> ticketlist=td.getTicketList(start, size);
		session.setAttribute("ticketlist", ticketlist);
		session.setAttribute("ticketpic", 0);
		req.getRequestDispatcher("ticketlist.jsp").forward(req, resp);
	}

}
