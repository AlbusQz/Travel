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

import dao.scenicdao;
import entity.Scenic;

/**
 * Servlet implementation class sceniclist
 */
@WebServlet("/sceniclist")
public class sceniclist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sceniclist() {
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
		scenicdao td = new scenicdao();
		int start;
		if(session.getAttribute("scenicstart")!=null)
		{
			start=(int) session.getAttribute("scenicstart");
			
		}
		else
		{
			start=0;
			session.setAttribute("scenicstart", start);
		}
		int pic=0;
		if(session.getAttribute("scenicpic")!=null)
		{
			start=(int) session.getAttribute("scenicpic");
			
		}
		else
		{
			pic=0;
			session.setAttribute("scenicpic", pic);
		}
		List<Scenic> sceniclist=td.getScenicList(start, 5);
		session.setAttribute("sceniclist", sceniclist);
		session.setAttribute("scenicpic", 0);
		req.getRequestDispatcher("/sceniclist.jsp").forward(req, resp);
	}

}
