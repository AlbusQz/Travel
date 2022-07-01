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

import dao.*;
import entity.Customer;
import entity.*;

/**
 * Servlet implementation class historylist
 */
@WebServlet("/historylist")
public class historylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public historylist() {
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
		hoteldao hd = new hoteldao();
		insurancedao id = new insurancedao();
		scenicdao sd = new scenicdao();
		linedao ld=new linedao();
		ticketdao td = new ticketdao();
		if(session.getAttribute("user")==null)
		{
			outs.write("<script language='javascript'>alert('您尚未登录！');window.location.href='/Travel_Web/login.jsp';</script>");
		}
		else
		{
			Customer user = (Customer) session.getAttribute("user");
			historydao hisd = new historydao();
			List<History> his=hisd.findHistorybyid(user.getId());
			for(int i=0;i<his.size();i++)
			{
				History temp = his.get(i);
				String t=temp.getType();
				if(t.equals("Insurance"))
				{
					t=id.findInsurance(temp.getPId()).getName();
					his.get(i).setType(t);
				}
				else
				if(t.equals("Line"))
				{
					t=ld.findLine(temp.getPId()).getName();
					his.get(i).setType(t);
				}
				else
				if(t.equals("Hotel"))
				{
					t=hd.findHotel(temp.getPId()).getName();
					his.get(i).setType(t);
				}
				else
				if(t.equals("Scenic"))
				{
					t=sd.findScenic(temp.getPId()).getName();
					his.get(i).setType(t);
				}
				else
				if(t.equals("Ticket"))
				{
					Ticket ti=td.findTicket(temp.getPId());
					t=ti.getTcity().getName()+"到"+ti.getRcity().getName()+"的"+ti.getType();
					his.get(i).setType(t);
				}
				else
				{
					his.get(i).setType("其他");
				}
				
			}
			session.setAttribute("History", his);
			req.getRequestDispatcher("/history.jsp").forward(req, resp);
		}
		
	
	}

}
