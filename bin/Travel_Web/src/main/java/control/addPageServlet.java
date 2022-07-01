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

import dao.ticketdao;
import entity.Ticket;

/**
 * Servlet implementation class addPageServlet
 */
@WebServlet("/addPageServlet")
public class addPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter outs=resp.getWriter();
		HttpSession session = req.getSession();
		resp.setCharacterEncoding("UTF-8");
		ticketdao td = new ticketdao();
		long total=td.getCount();
		int start;
		if(session.getAttribute("ticketstart")!=null)
		{
			start=(int) session.getAttribute("ticketstart");
			
		}
		else
		{
			start=0;
			
		}
		if(start+5<=total)
		{
			start+=5;
			session.setAttribute("ticketstart", start);
		}
		List<Ticket> ticketlist=td.getTicketList(start, 5);
		session.setAttribute("ticketlist", ticketlist);
		req.getRequestDispatcher("/ticketlist.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
