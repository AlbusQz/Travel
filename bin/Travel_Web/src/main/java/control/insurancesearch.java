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

import dao.insurancedao;
import entity.Insurance;

/**
 * Servlet implementation class insurancesearch
 */
@WebServlet("/insurancesearch")
public class insurancesearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insurancesearch() {
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
		insurancedao td = new insurancedao();
		String query=req.getParameter("queryword");
		int start;
		if(session.getAttribute("insurancestart")!=null)
		{
			start=(int) session.getAttribute("insurancestart");
			
		}
		else
		{
			start=0;
			session.setAttribute("insurancestart", start);
		}
		int pic=0;
		if(session.getAttribute("insurancepic")!=null)
		{
			start=(int) session.getAttribute("insurancepic");
			
		}
		else
		{
			pic=0;
			session.setAttribute("insurancepic", pic);
		}
		List<Insurance> insurancelist=td.getSearchInsuranceList(query);
		session.setAttribute("insurancelist", insurancelist);
		session.setAttribute("insurancepic", 0);
		req.getRequestDispatcher("/insurancesearch.jsp").forward(req, resp);
	}


}
