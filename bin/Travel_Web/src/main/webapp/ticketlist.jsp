<%@page import="java.util.*"%>
<%@ page language="java" import="entity.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>SIMPLE</title>

    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
   
    <link rel="stylesheet" href="js/prettyPhoto/css/prettyPhoto.css" type="text/css" media="screen" />
    <!-- ENDS prettyPhoto -->

    <!-- JS -->
    <script type="text/javascript" src="js/jquery_1.4.2.js"></script>
    <script type="text/javascript" src="js/jqueryui.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript" src="js/jquery.cycle.all.js"></script>
    <script type="text/javascript" src="js/tooltip/jquery.tools.min.js"></script>
    <script type="text/javascript" src="js/filterable.pack.js"></script>
    <script type="text/javascript" src="js/prettyPhoto/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="js/twitter.js"></script>
    <script type="text/javascript" src="js/jquery.tabs/jquery.tabs.pack.js"></script>
    <script type="text/javascript" src="js/custom.js"></script>
    <!-- ENDS JS -->

    <!-- Cufon -->
    <script src="js/cufon-yui.js" type="text/javascript"></script>
    <script src="js/fonts/bebas-neue_400.font.js" type="text/javascript"></script>
    <!-- /Cufon -->

    <!-- superfish -->
    <link rel="stylesheet" type="text/css" media="screen" href="css/superfish-custom.css" />
    <script type="text/javascript" src="js/superfish-1.4.8/js/hoverIntent.js"></script>
    <script type="text/javascript" src="js/superfish-1.4.8/js/superfish.js"></script>
    <!-- ENDS superfish -->

  
    <link rel="stylesheet" href="css/jquery.tabs.css" type="text/css" media="print, projection, screen" />
   

</head>


<body>

<!-- HEADER -->
<div id="header">
    <div class="degree">
        <div class="wrapper">
            <a href="index.html"><img src="img/logo4.png" alt="Logo" id="logo" /></a>

            <!-- search -->
            <div class="top-search">
                <form  method="post" id="searchform" action="ticketsearch">
                    <div>
                        <input type="text" value="Search..." name="queryword" id="s" onfocus="defaultInput(this)" onblur="clearInput(this)" />
                        <input type="submit" id="searchsubmit" value=" " />
                    </div>
                </form>
            </div>
            <!-- ENDS search -->

            <!-- navigation -->
            <div id="nav-holder">
              <ul id="nav" class="sf-menu">
                    <li><a href="index.html">HOME</a></li>
                    <li ><a href="hotellist">HOTEL</a></li>
                    <li ><a href="sceniclist">SCENIC</a></li>
                    <li  class="current_page_item"><a href="ticketlist">TICKET</a></li>
                    <li ><a href="linelist">LINE</a></li>
                    <li><a href="tiplist">TIP</a></li>
                    <li><a href="insurancelist">INSURANCE</a></li>
                    <li><a href="contact.html">CONTACT</a></li>
                    <li><a href="staff.html">STAFF</a></li>
                    <li><a href="login.jsp">LOGIN</a></li>
                    <li><a href="historylist">HISTORY</a></li>
                </ul>
            </div>
            <!-- ENDS navigation -->

        </div>
        <!-- ENDS HEADER-wrapper -->
    </div>
</div>
<!-- ENDS HEADER -->

<!-- MAIN -->
<div id="main">
    <!-- wrapper -->
    <div class="wrapper">
        <!-- content -->
        <div class="content">
            <!-- title -->
            <div class="title-holder"><br>
                <b style="font-size: x-large;">&nbsp;&nbsp;&nbsp;&nbsp;购票</b>
                <ul class="portfolio-pager">
                    <li><a href="subPageServlet">NEWER</a></li><!--上一页按钮-->
                    <li class="last-child"><a href="addPageServlet">OLDER</a></li><!--下一页按钮-->
                </ul>
            </div>
            <!-- ENDS title -->
			
            <!-- page-content -->
            <div class="page-content">


<%	if(session.getAttribute("ticketlist")!=null)
			{
				List<entity.Ticket> ticketlist =(List<entity.Ticket>)session.getAttribute("ticketlist");
				//int start =(int) session.getAttribute("start"); 
				for(int i=0;i<ticketlist.size()&&i<5;i++)
				{
					Ticket temp=ticketlist.get(i);
					out.print("<ul class='staff'>  <a href='ticketshow?ticketshowid="+i+"' > <li> ");
					out.print("<img src='ticketpic"+i+"'/> ");
					out.print("<div class='information'>"+temp.getTcity().getName()+"————>"+temp.getRcity().getName());
					out.print(" <div class='header'>出发日期："+temp.getTTime().toString());
					out.print(" <div class='contact'>到达时间："+temp.getRTime().toString());
					//out.print(" <div class='contact'>出行方式："+temp.getType());
					out.print("</div> <div style='font-size: xx-large; float:right'>￥"+temp.getPrice());
					out.print("</div>   <div class='contact'></div>     </div>    </div>   </li>    </a> <div class='contact'>  </div></ul><hr><br> ");
					//start++;
					//session.setAttribute("start",start);
				}
						
			}
				
%>

             

    </div>
    <!-- ENDS content -->

    <!-- twitter -->
    <div class="twitter-reader">
        <div id="twitter-holder"></div>
    </div>
    <!-- ENDS twitter -->

</div>
<!-- ENDS main-wrapper -->


</div>
<!-- ENDS MAIN -->

<div id="footer">
    <div class="degree">
        <div class="wrapper">
            <ul class="footer-cols" style="position:relative;	left:100px;">
                <li class="col">
                    <h6>Info</h6>
                    <ul>
                        <li><a href="#">酒店索引</a></li>
                        <li><a href="#/">机票索引</a></li>
                        <li><a href="#">高铁索引</a></li>
                        <li><a href="#">景区索引</a></li>
                    </ul>
                </li>
                          <li class="col" style="width:100px"></li>    
                 <li class="col">
                    <h6>COOPERATION</h6>
                    <ul>
                        <li><a href="#">酒店加盟</a></li>
                        <li><a href="#">景区合作</a></li>
                        <li><a href="#">更多加盟合作</a></li>
                    </ul>
                </li>
                    
                     <li class="col" style="width:100px"></li>    
                <li class="col">
                    <h6>ABOUT</h6>
                    <ul>
                        <li><a href="#">关于我们</a></li>
                        <li><a href="contact.html">联系我们</a></li>
                        <li><a href="#">隐私政策</a></li>
                        <li><a href="#">安全中心</a></li>
                    </ul>
               
                </li>
               
            </ul>
        </div>

</div>


<!-- start cufon -->
<script type="text/javascript"> Cufon.now(); </script>
<!-- ENDS start cufon -->

</body>
</html>
