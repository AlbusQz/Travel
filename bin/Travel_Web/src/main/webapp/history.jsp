<%@page import="java.util.*"%>
<%@ page language="java" import="entity.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>购买记录</title>

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
   
        <style>
    .table11_6 table {
        width:100%;
        margin:15px 0;
        border:0;
    }
    .table11_6 th {
        background-color:#96C7ED;
        color:#000000
    }
    .table11_6,.table11_6 th,.table11_6 td {
        font-size:15px;
        text-align:center;
        padding:4px;
        border-collapse:collapse;
    }
    .table11_6 th,.table11_6 td {
        border: 1px solid #73b4e7;
        border-width:1px 0 1px 0;
        border:2px inset #ffffff;
    }
    .table11_6 tr {
        border: 1px solid #ffffff;
    }
    .table11_6 tr:nth-child(odd){
        background-color:#dcecf9;
    }
    .table11_6 tr:nth-child(even){
        background-color:#ffffff;
    }
</style>

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
                    <li><a href="hotellist">HOTEL</a></li>
                    <li><a href="sceniclist">SCENIC</a></li>
                    <li ><a href="ticketlist">TICKET</a></li>
                    <li ><a href="linelist">LINE</a></li>
                    <li><a href="tiplist">TIP</a></li>
                    <li><a href="insurancelist">INSURANCE</a></li>
                    <li><a href="contact.html">CONTACT</a></li>
                    <li><a href="login.jsp">LOGIN</a></li>
                    <li class="current_page_item"><a href="historylist">HISTORY</a></li>
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
                <b style="font-size: x-large;">&nbsp;&nbsp;&nbsp;&nbsp;您的购买记录：</b>
               
            </div>
            <div class="page-content">
     <table class=table11_6>
    <tr>
        <th>订单序列号</th><th>购买物品</th><th>价格</th><th>订单状态</th><th>购买时间</th>
    </tr>
    <%
    	List<History> his=(List<History>)session.getAttribute("History");
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	for(int i=0;i<his.size();i++)
    	{
    		History temp = his.get(i);
    		out.print("<tr>");
    		out.print("<td>"+temp.getId()+"</td>");
    		out.print("<td>"+temp.getType()+"</td>");
    		out.print("<td>"+temp.getPrice()+"</td>");
    		out.print("<td>"+temp.getState()+"</td>");
    		out.print("<td>"+sdf.format(temp.getCtime())+"</td>");
    	}
    %>
   
</table>
</div>
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
