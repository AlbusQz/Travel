<%@page import="entity.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>MyTravel</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="js/prettyPhoto/css/prettyPhoto.css" type="text/css" media="screen" />
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
    <script src="js/cufon-yui.js" type="text/javascript"></script>
    <script src="js/fonts/bebas-neue_400.font.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="css/superfish-custom.css" />
    <script type="text/javascript" src="js/superfish-1.4.8/js/hoverIntent.js"></script>
    <script type="text/javascript" src="js/superfish-1.4.8/js/superfish.js"></script>
    <link rel="stylesheet" href="css/jquery.tabs.css" type="text/css" media="print, projection, screen" />
    <style type="text/css">
        .body
        {
            font: 12px/1.5 PingFangSC-Regular,"Microsoft YaHei",SimSun,Tahoma,Verdana,Arial,sans-serif;
            color: #666;
            background-color: #FFF;
        }
        .rect
        {
            position: relative;
            float: right;
            width: 400px;
            height:400px;
            margin-right: 52px;
            margin-top:50px;
              background-color: #34495e;
				text-align-last: left;
				/*半透明效果*/
				filter:alpha(Opacity=60);
				-moz-opacity:0.8;
				opacity: 0.8;
        }
        .login
        {
            /* margin-right: 72px; */
    
            position:relative;
            left: 40px;
    		
            font-size: 18px;
            color: #ccccd6;
            line-height: 1;
            padding-bottom: 16px;
            font-family: PingFangSC-Medium,"Microsoft Yahei",SimSun,Tahoma,Verdana,Arial,sans-serif;
        }
    
        dl
        {
            display: block;
            margin-block-start: 1em;
            margin-block-end: 1em;
            margin-inline-start: 0px;
            margin-inline-end: 0px;
        }
    
    	.logincontext {
				position: relative;
			 	width: 500px;
           		 height: 400px;
				background-color: #34495e;
				text-align-last: center;
				/*半透明效果*/
				filter:alpha(Opacity=60);
				-moz-opacity:0.8;
				opacity: 0.8;
}
        .input1
        {
            position: relative;
            left:20px;
            width: 320px;
            height: 40px;
            padding: 5px 5px 5px 13px;
            line-height: 28px;
            border: 1px solid #ccc;
            font-size: 14px;
            color: #333;
            display: inline-block;
            vertical-align: middle;
            
        }
    
        .input2
        {
            position: relative;
            width: 320px;
            left:20px;
            height: 40px;
            padding: 5px 5px 5px 13px;
            line-height: 28px;
            border: 1px solid #ccc;
            font-size: 14px;
            color: #333;
            display: inline-block;
            vertical-align: middle;
            
        }  
        .form_btn
        {
            background-color: black;
             text-align: center;
            width: 220px;
            height: 42px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            border: 0;
            border-radius: 4px;
            clear: both;
        }
    
        .form_btn--block
        {
            width: 80%;
            position: relative;
            left:20px;
            top: 35px;
            text-align: center;
        } 
    
        .forgotpwd
        {
            position: absolute;
            right: 0;
            top: 0;
            width: 80px;
            height: 40px;
            line-height: 40px;
            text-align: right;
            font-size: 12px;
            outline: 0;
            outline-color: initial;
            outline-style: initial;
            outline-width: 0px;
            color: #c4d7d6;
            text-decoration: none;
            text-decoration-line: none;
            text-decoration-thickness: initial;
            text-decoration-style: initial;
            text-decoration-color: initial;
        }
    
        .login-line
        {
            outline: 0;
            outline-color: initial;
            outline-style: initial;
            outline-width: 0px;
            color: #c4d7d6;
            text-decoration: none;
            text-decoration-line: none;
            text-decoration-thickness: initial;
            text-decoration-style: initial;
            text-decoration-color: initial;
            position: relative;
            /* margin-right: 20px; */
            left: 20px;
            top: 20px;
        }
        
        .verify
        {
            position:relative;
            top:0px;
            width:320px;
            height:42px;
        }
        
        .verify1
        {
            position:relative;
            left:20px;
            width:240px;
            height:42px;
            line-height: 28px;
            border: 1px solid #ccc;
            font-size: 14px;
            padding: 0px 0px 5px 13px;
            display: inline-block;
            vertical-align: middle;
        }

        .mid
        {
            width: 1200px;
            height:500px;
          

        }
        #identify_img
        {
        width:60px;
        height:42px;
        position:relative;
        top:13px;
        left:15px;
        }
        </style>
    
</head>

<body>
<div id="header">
    <div class="degree">
        <div class="wrapper">
            <a href="index.html"><img src="img/logo4.png" alt="Logo" id="logo" /></a>
            <div id="nav-holder">
               <ul id="nav" class="sf-menu">
                    <li><a href="index.html">HOME</a></li>
                    <li ><a href="hotellist">HOTEL</a></li>
                    <li><a href="sceniclist">SCENIC</a></li>
                    <li ><a href="ticketlist">TICKET</a></li>
                    <li ><a href="linelist">LINE</a></li>
                    <li><a href="tiplist">TIP</a></li>
                    <li><a href="insurancelist">INSURANCE</a></li>
                    <li><a href="contact.html">CONTACT</a></li>
                      <li  class="current_page_item"><a href="login.jsp">LOGIN</a></li>
                      <li><a href="historylist">HISTORY</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function refresh()
    {
        document.getElementById("identify_img").src="verification_code.jsp?id="+Math.random();
    }
</script>


<form action="LoginServlet" method="post" style="  background-size: cover;
           background-image:url(img/back1.jpg);
           background-repeat: repeat;">

<div id="main" class="mid"  >

    <div class="rect">
    <br/>
        <div class="login">
            账号登录
        </div>
        <div class="input" style>
            <dl>
                <dd>
                    <input class="input1" type="text" name="name" placeholder="国内手机号/账号" >
                </dd>
            </dl>    
            <dl>
                <dd>
                    <input class="input2" type="password" name="password" placeholder="登录密码" data-noneedeye>
                    <a href="retrive1.html" class="forgotpwd" target="black">忘记密码</a>
                </dd>
            </dl>
           <dl>
                <dd>
                    
                <input class="verify1" type="text" placeholder="验证码" maxlength="4" name="code" required=""/>
    
            <img id="identify_img" src="verification_code.jsp" onclick="refresh()" title="点击刷新" style="height: 42px;left:40px;">
                </dd>
            </dl>
           
        </div>
        
    
    
        
            <dd>
                <a href="register.jsp" class="login-line">没有账号？点此注册</a>
            </dd>
    
            <dd>
                <input class="form_btn form_btn--block" type="submit" value="&nbsp&nbsp&nbsp登    录">
            </dd>
    </div>
</div>


</form>

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



<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
