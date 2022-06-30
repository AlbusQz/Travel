package tool;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Ticket;

/**
 * Servlet implementation class ticketpic0
 */
@WebServlet("/ticketpic2")
public class ticketpic2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ticketpic2() {
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
		HttpSession session = req.getSession();
		resp.setCharacterEncoding("UTF-8");
		
		if(session.getAttribute("ticketpic")!=null)
		{
		//	pic=(int) session.getAttribute("ticketpic");
			
		}
		int pic=2;
		List<Ticket> out=null;
		if(session.getAttribute("ticketlist")!=null)
		{
			out=(List<Ticket>) session.getAttribute("ticketlist");
		}
		Ticket temp = out.get(pic);
		byte[] buffer = temp.getPic(); 
		InputStream in = new ByteArrayInputStream(buffer); 
		BufferedImage img1 = ImageIO.read(in);
		BufferedImage img2 = new BufferedImage(140, 90, BufferedImage.TYPE_INT_RGB);
		img2.getGraphics().drawImage(img1, 0, 0, 140, 90, null); 
		resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        OutputStream output = resp.getOutputStream();  
        ImageIO.write(img2, "jpg", output);
        System.out.println("test");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
