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

import entity.Line;

/**
 * Servlet implementation class lineshow
 */
@WebServlet("/lineshow")
public class lineshow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lineshow() {
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
		String lineshowid=req.getParameter("lineshowid");
		int i=0;
		if(lineshowid!=null)
		{
			i=lineshowid.charAt(0)-'0';
		}
		PrintWriter outs=resp.getWriter();
		HttpSession session = req.getSession();
		resp.setCharacterEncoding("UTF-8");
		List<Line> linelist =(List<Line>) session.getAttribute("linelist");
		if(linelist!=null)
		{
			Line t=linelist.get(i);
			session.setAttribute("lineshow", t);
			req.getRequestDispatcher("/lineshow.jsp").forward(req, resp);
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
