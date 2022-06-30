<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
  import ="java.awt.*"
   import ="java.awt.image.BufferedImage"
   import="java.util.*"
   import="javax.imageio.ImageIO"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>verification_code</title>
</head>
<body>

<%
	response.setHeader("Cache-Control","no-cache");
	
	 int width=60,height=42;
	 BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	 
	 Graphics g=image.getGraphics();
	 g.setColor(new Color(86,152,195));
	 g.fillRect(0,0,width,height);
	 
	 Random rnd=new Random();
	 int randNum=rnd.nextInt(8999)+1000;
	 String Code=String.valueOf(randNum);
	 
	 session.setAttribute("Code",Code);
	 
	 g.setColor(Color.black);
	 g.setFont(new Font("", Font.PLAIN,20));
	 g.drawString(Code,20,21);
	 
	 for (int i = 0; i < 100; i++) {		//干扰点
	  int x=rnd.nextInt(width);
	  int y=rnd.nextInt(height);
	  g.drawOval(x,y,1,1);
	 }
	 
	 ImageIO.write(image,"PNG",response.getOutputStream());
	 out.clear();
	 out=pageContext.pushBody();
 
%>

</body>
</html>