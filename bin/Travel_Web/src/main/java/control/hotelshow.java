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

import entity.Hotel;

/**
 * Servlet implementation class hotelshow
 */
@WebServlet("/hotelshow")
public class hotelshow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotelshow() {
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
		String hotelshowid=req.getParameter("hotelshowid");
		int i=0;
		if(hotelshowid!=null)
		{
			i=hotelshowid.charAt(0)-'0';
		}
		PrintWriter outs=resp.getWriter();
		HttpSession session = req.getSession();
		resp.setCharacterEncoding("UTF-8");
		List<Hotel> hotellist =(List<Hotel>) session.getAttribute("hotellist");
		if(hotellist!=null)
		{
			Hotel t=hotellist.get(i);
			session.setAttribute("hotelshow", t);
			req.getRequestDispatcher("/hotelshow.jsp").forward(req, resp);
		}
		else
		{
			req.getRequestDispatcher("/index.html").forward(req, resp);
		}
		//outs.print(i);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
