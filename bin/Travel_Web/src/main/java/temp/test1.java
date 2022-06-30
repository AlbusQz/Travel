package temp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import entity.*;
/**
 * Servlet implementation class test1
 */
@WebServlet("/test1")
public class test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test1() {
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
		persondao pd = new persondao();
		Person p = pd.findPerson("370313200201011010");
		long id=p.getCustomer().getId();
		System.out.println(id);
		hoteldao hd= new hoteldao();
		List<Hotel> out=hd.getHotelList(0,9);
		for(int i=0;i<out.size();i++)
		{
			//OutputStream output = resp.getOutputStream();  
		//	output.write(out.get(i).getName()+"<br/>");
			//resp.getWriter().print(hd.getCount());
			//resp.getWriter().print(out.get(i).getName()+"<br/>");
		//	resp.getWriter().close();
			byte[] buffer = out.get(i).getPic();
			 resp.setContentType("image/png");  
			
			InputStream in = new ByteArrayInputStream(buffer); 
			BufferedImage img = ImageIO.read(in);
			resp.setHeader("Pragma", "no-cache");
            resp.setHeader("Cache-Control", "no-cache");
            resp.setDateHeader("Expires", 0);
            OutputStream output = resp.getOutputStream();  
            ImageIO.write(img, "jpg", output);
            out.clear();  
		////	int len;  
			//byte[] buf = new byte[1024];  
			//while ((len = in.read(buf)) != -1) {  
			//   output.write(buf, 0, len);  
			//}  
		//	output.flush();  
			//如果没有下面两行，可能出现getOutputStream() has already been called for this response的异常  
		//	out.clear();  
		
		}
		//resp.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
