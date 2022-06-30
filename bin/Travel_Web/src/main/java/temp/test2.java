package temp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.*;
import dao.*;
/**
 * Servlet implementation class test2
 */
@WebServlet("/test2")
public class test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Customer customer = new Customer();
		customerdao cd = new customerdao();
		Person p =new Person();
		persondao pd = new persondao();
		customer.setPassword("12345678");
		customer.setName("test");
		cd.addCustomer(customer);
		p.setId("370212200112141016");
		p.setName("²âÊÔ");
		p.setNationality("ºº×å");
		p.setSex("ÄÐ");
		p.setCustomer(customer);
		cd.addPerson(customer, p);
		
		
		///pd.addPerson(p);
		System.out.println("Yep!");
		//p.set
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
