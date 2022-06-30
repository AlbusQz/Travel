<%@page import="java.util.*"%>
<%@ page language="java" import="entity.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />

    <title>旅游攻略</title>

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

    <!-- tabs -->
    <link rel="stylesheet" href="css/jquery.tabs.css" type="text/css" media="print, projection, screen" />
 <style type="text/css">
#allmap{height:500px;width:100%;}
#r-result{width:100%; font-size:14px;}
 .button1{
				 background-color:#11659a;
    border: none;
    color: white;
    font-family:Arial;
    padding: 10px 24px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 18px;
    margin: 4px 2px;
    cursor: pointer; 
    right:30px;        
			}
</style>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=XO5AgcOAK5I8l7GgHMQqT3vYt9lWGDTN"></script>
</head>


<body>

<!-- HEADER -->
<div id="header">
    <div class="degree">
        <div class="wrapper">
            <a href="index.html"><img src="img/logo4.png" alt="Logo" id="logo" /></a>
            <!-- navigation -->
            <div id="nav-holder">
                <ul id="nav" class="sf-menu">
                    <li><a href="index.html">HOME</a></li>
                    <li ><a href="hotel.jsp">HOTEL</a></li>
                    <li><a href="portfolio.html">SCENIC SPOT</a></li>
                    <li class="current_page_item"><a href="ticketlist">TICKET</a></li>
                    <li><a href="strategy.html">STRATEGY</a></li>
                    <li><a href="gallery.html">INSURANCE</a></li>
                    <li><a href="contact.html">CONTACT</a></li>
                    <li><a href="staff.html">STAFF</a></li>
                    <li><a href="login.jsp">LOGIN</a></li>
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
        <div class="content-blog">

            <!-- POSTS -->
            <div id="posts">
                <!-- post -->
              <div class="post"style="border-right: 3px solid #369;">
                    <!-- post-header -->
                    <div class="post-header">
                        <div><b style="font-size: x-large;">旅游车票</b></div>

                    </div>
                    <!-- ENDS post-header -->
                    <%
                    Ticket ticket =null;
					if(session.getAttribute("ticketshow")!=null)
					{
						ticket =(Ticket)session.getAttribute("ticketshow");
					}
					
					%>
                    
                    <!-- post-content -->
                    <div>
                        <img src="ticketpic" alt="Dummy" title="dummy-about-2" />
                    </div>

				

                  
				
                </div>

            </div> 
            <div>
            <ul2 >
                <%
                        	out.print("<br/><br/><p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp出发地:"+ticket.getTcity().getName()+"</p>");
                        	out.print("<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp目的地:"+ticket.getRcity().getName()+"</p>");
                        	out.print("<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp价格:"+ticket.getPrice()+"</p>");
                        	out.print("<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp出发时间:"+ticket.getTTime().toString()+"</p>");
                        	out.print("<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp到达时间:"+ticket.getRTime().toString()+"</p>");
                        	out.print("<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp车票类型:"+ticket.getType()+"</p>");
                        	boolean havelogin=false;
                        	if(session.getAttribute("havelogin")!=null)
                        	{
                        		havelogin=(boolean)session.getAttribute("havelogin");
                        	}
                        	else
                        	session.setAttribute("havelogin", havelogin);
                    %>
                    <p><a href='buyTicketServlet' >
                    <% if(havelogin)
                	{
                		out.print( "<button type='button'class='button1'>点击购买</button>");
                	}
                    else
                    {
                		out.print( "<button type='button' disabled='disabled'class='button1'>购买前请先登录</button>");
                	}	
             		%>
                    	</a></p>
                        	
            </ul2>
            </div>
            
            </div>
   
				

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
<script type="text/javascript">
// 百度地图API功能
var map = new BMap.Map("allmap");
var point1 = new BMap.Point(ticket.getTcity().getLng(),ticket.getTcity().getLat());
var point2 = new BMap.Point(ticket.getRcity().getLng(),ticket.getRcity().getLat());
var point = new BMap.Point((point1.lng+point2.lng)/2,(point1.lat+point2.lat)/2);
map.centerAndZoom(point,6);
var marker = new BMap.Marker(point);
marker.enableDragging()//可拖拽
map.enableScrollWheelZoom(true);   
var line= new BMap.Polyline([
	point1,point2
],
{strokeColor:"red"});
map.addOverlay(line);
var mk1=new BMap.Marker(point1);
mk1.setLabel(new BMap.Label("起点"));
map.addOverlay(mk1);
var mk2=new BMap.Marker(point2);
mk2.setLabel(new BMap.Label("终点"));
map.addOverlay(mk2);

</script>