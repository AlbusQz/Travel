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

import dao.hoteldao;
import entity.Hotel;

/**
 * Servlet implementation class hotelsearch
 */
@WebServlet("/hotelsearch")
public class hotelsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotelsearch() {
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
		hoteldao td = new hoteldao();
		String query=req.getParameter("queryword");
		int start;
		if(session.getAttribute("hotelstart")!=null)
		{
			start=(int) session.getAttribute("hotelstart");
			
		}
		else
		{
			start=0;
			session.setAttribute("hotelstart", start);
		}
		int pic=0;
		if(session.getAttribute("hotelpic")!=null)
		{
			start=(int) session.getAttribute("hotelpic");
			
		}
		else
		{
			pic=0;
			session.setAttribute("hotelpic", pic);
		}
		List<Hotel> hotellist=td.getSearchHotelList(query);
		session.setAttribute("hotellist", hotellist);
		session.setAttribute("hotelpic", 0);
		req.getRequestDispatcher("/hotelsearch.jsp").forward(req, resp);
	}


}
