<%@page import="java.util.*"%>
<%@ page language="java" import="tool.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>注册</title>
    <style type="text/css">
    .cui_bd {
        margin: 20px auto;
        width: 1000px;
        padding: 0 10px;
        min-height: 500px;
    }
    .reg_wrap {
    position: relative;
    z-index: 1;
    min-height: 350px;
    padding-right: 260px;
}
.hh_reg_wrap {
    padding: 0;
}
#slideCode {
    position: relative;
    display: block;
    width: 300px;
    height: 40px;
    background: rgb(235, 235, 235);
    border-radius: 2px;
}
.reg_step {
    margin: 0 0 30px -12px;
}
#slider, .alert_box, .base_label input, .cfix:after, .clause_wrap, .ctriplogo_reg a, .get_verify-code, .layoutfix, .phone_sel_pop, .phone_sel_pop dd, .phone_sel_pop dd a, .phone_sel_pop dl, .pic_banner, .reg_card_box, .reg_card_list, .reg_card_list dd, .reg_card_list dd a, .reg_form dd .r_input.input_country-code, .reg_form dl:after, .reg_step, .reg_step span, .reg_success, .reg_title, .reg_wrap, .remark_box, .verify_wrap .reg_form dt {
    overflow: hidden;
}
.hh_reg_wrap .reg_step li.current {
    background-position: 255px -228px;
}
ul, ol {
    list-style: none;
}
.hh_reg_wrap .reg_step li {
    background-position: 255px -285px;
}
.reg_step li.current {
    background-position: 157px -228px;
    color: #799d08;
}
.reg_step li {
    float: left;
    margin-left: 12px;
    background-position: 157px -285px;
    color: #9a9a9a;
}
.bbz_accounts_logo_hd .assist {
    float: right;
    padding: 0 15px 0 13px;
    line-height: 90px;
    color: #666;
    cursor: pointer;
}
html, body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, textarea, p, blockquote, th, td, em, button {
    margin: 0;
    padding: 0;
}
#slideCode .cpt-loading-box {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 40px;
    z-index: 10;
    font-size: 14px;
    text-align: center;
    background: rgb(235, 235, 235);
    -moz-user-select: none;
    overflow: hidden;
    -webkit-user-select: none;
    -ms-user-select: none;
    -khtml-user-select: none;
    user-select: none;
    border-radius: 2px;
    font-weight: bold;
}
#slideCode .cpt-loading-icon-content {
    display: inline-block;
    height: 18px;
    width: 18px;
    overflow: hidden;
    margin: 11px 5px 11px 0;
}
#slideCode i.cpt-loading-right {
    position: static;
    display: block;
    line-height: 40px;
    background-position: -68px -0px;
}
#slideCode .cpt-loading-info-container {
    position: relative;
    overflow: hidden;
    height: 40px;
    width: 268px;
    margin: 0 16px;
}
.reg_form dd img {
    width: 98px;
    height: 34px;
    margin: 0 10px 0 6px;
    vertical-align: middle;
    border: 1px solid #666;
}
fieldset, img {
    border: none;
    vertical-align: middle;
}
#slideCode .cpt-loading-img {
    display: inline-block;
    width: 20px;
    height: 20px;
    margin-top: 10px;
    min-width: 10px;
    min-height: 10px;
}
#slideCode div {
    float: none;
    width: auto;
    height: auto;
    display: block;
    padding: 0;
    margin: 0;
    border: 0px;
    line-height: 1.428571429;
    box-sizing: content-box;
    -moz-box-sizing: content-box;
    -webkit-box-sizing: content-box;
}
#slideCode .cpt-loading-text {
    display: none;
    color: #455873;
    z-index: 0;
    line-height: 40px;
    white-space: nowrap;
    vertical-align: top;
}
#slideCode .cpt-loading-info-box {
    display: none;
    height: 40px;
    overflow: hidden;
    white-space: nowrap;
}
body {
    font: 12px/1.5 'Microsoft yahei', arial, Simsun, sans-serif;
    color: #333;
    background-color: #fff;
}
.reg_form dl:after {
    height: 0;
}
.reg_step li.current span {
    background-color: #acd252;
}
.hh_reg_wrap .reg_step span {
    width: 270px;
}
.reg_step span {
    display: inline-block;
    margin-right: 5px;
    width: 170px;
    height: 5px;
    line-height: 0;
    background-color: #ddd;
    border-radius: 3px;
    vertical-align: middle;
}
.reg_form dd .r_input.input_country-code {
    min-width: 80px;
    max-width: 300px;
    width: auto;
    padding-right: 40px;
    white-space: nowrap;
    text-overflow: ellipsis;
    display: inline-block;
}
#label, .alert_box i, .base_error i, .base_success i, .base_tip i, .link_code, .reg_card_more .ico_down, .reg_card_more .ico_up, .reg_step li, .reg_success i, .remark_box dd, .to_card i, .to_mail i, .to_member i, .to_phone i {
    display: inline-block;
    background: url(//pic.c-ctrip.com/platform/online/register/un_reg_7.4.png) 0 -9999em no-repeat;
    vertical-align: middle;
}
dt {
    display: block;
}
.reg_form dt {
    float: left;
    margin-right: 10px;
    width: 130px;
    line-height: 36px;
    font-size: 14px;
    text-align: right;
}
#slider, .alert_box, .base_label input, .cfix:after, .clause_wrap, .ctriplogo_reg a, .get_verify-code, .layoutfix, .phone_sel_pop, .phone_sel_pop dd, .phone_sel_pop dd a, .phone_sel_pop dl, .pic_banner, .reg_card_box, .reg_card_list, .reg_card_list dd, .reg_card_list dd a, .reg_form dd .r_input.input_country-code, .reg_form dl:after, .reg_step, .reg_step span, .reg_success, .reg_title, .reg_wrap, .remark_box, .verify_wrap .reg_form dt {
    overflow: hidden;
}
#label, .alert_box i, .base_error i, .base_success i, .base_tip i, .link_code, .reg_card_more .ico_down, .reg_card_more .ico_up, .reg_step li, .reg_success i, .remark_box dd, .to_card i, .to_mail i, .to_member i, .to_phone i {
    display: inline-block;
    background: url(//pic.c-ctrip.com/platform/online/register/un_reg_7.4.png) 0 -9999em no-repeat;
    vertical-align: middle;
}
.reg_form dd .r_input {
    position: relative;
    width: 283px;
    height: 28px;
    line-height: 28px;
    padding-left: 10px;
    vertical-align: middle;
    font-size: 14px;
    color: #333;
    border-color: #ccc;
}.r_input {
    height: 24px;
    padding: 5px;
    line-height: 24px;
    border: 1px solid #ddd;
    font-size: 15px;
    color: #bbb;
}
input[type='text'] {
    border-radius: 0;
}
.r_input {
    height: 24px;
    padding: 5px;
    line-height: 24px;
    border: 1px solid #ddd;
    font-size: 15px;
    color: #bbb;
}
input, textarea {
    font-size: 12px;
}
.reg_form dl:after {
    height: 0;
}#slider, .alert_box, .base_label input, .cfix:after, .clause_wrap, .ctriplogo_reg a, .get_verify-code, .layoutfix, .phone_sel_pop, .phone_sel_pop dd, .phone_sel_pop dd a, .phone_sel_pop dl, .pic_banner, .reg_card_box, .reg_card_list, .reg_card_list dd, .reg_card_list dd a, .reg_form dd .r_input.input_country-code, .reg_form dl:after, .reg_step, .reg_step span, .reg_success, .reg_title, .reg_wrap, .remark_box, .verify_wrap .reg_form dt {
    overflow: hidden;
}.cfix:after, .reg_form dl:after {
    content: '.';
    clear: both;
    display: block;
    overflow: hidden;
}.reg_form dd {
    float: left;
    padding-right: 10px;
}
dl {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
}dd {
    display: block;
    margin-inline-start: 40px;
}.reg_form dd .r_input {
    position: relative;
    width: 283px;
    height: 28px;
    line-height: 28px;
    padding-left: 10px;
    vertical-align: middle;
    font-size: 14px;
    color: #333;
    border-color: #ccc;
}.reg_form dd .r_input.input_auth-code input {
    border: none;
    width: 170px;
    height: 28px;
    line-height: 28px;
    outline: 0;
    font-size: 14px;
}
.reg_btn {
    background-color: #FF9A14;
}.reg_btn, .reg_btn_disabled {
    margin-bottom: 8px;
    width: 220px;
    height: 42px;
    color: #fff;
    font-size: 16px;
    cursor: pointer;
    text-align: center;
    border: 0 none;
    border-radius: 4px;
    *filter: chroma(color=#000);
    clear: both;
}

	.logincontext {
				position: relative;
			 	width: 500px;
           		 height: 500px;
				background-color: #34495e;
				text-align-last: center;
				/*半透明效果*/
				filter:alpha(Opacity=60);
				-moz-opacity:0.8;
				opacity: 0.8;
				margin:0 auto;
				top:50px;
}
    </style>
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
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- ENDS HEADER -->
<div id="main" style=" color:white;
 background-size: cover;
           background-image:url(img/back1.jpg);
           background-repeat: repeat;">
    <div class="cui_bd">
        <div class="reg_wrap hh_reg_wrap">
	<div class="logincontext ">
	<br/><br/><br/><br/>
            <div class="reg_form reg_form_step1">
           <form action="RegisterServlet" method="post" >
                <dl>
                    <dt class="label" id="phone" >手机号</dt>
                    
                    <dd>
                       
                        <input class="r_input input_country-code_num" type="text" placeholder="请输入有效手机号" id="mobilephone" name="phone"/>
                        <br><input type="hidden" id="codeResult"><br>
                        <input type="hidden" id="nameResult"></dd>
                </dl>
                <br/>
                <%
                if(session.getAttribute("code")==null)
                {
                	int code= (int)(1000+Math.random()*(9999-1000+1));//(int)1000;// 
                    session.setAttribute("code", String.valueOf(code));
                    java.util.concurrent. TimeUnit.SECONDS.sleep(30);
                    sendTool.send("17685515217", String.valueOf(code));
                }
                
               // System.out.print(code);
               // sendTool.send("17685515217", String.valueOf(code));
                %>
   				 <dl>
                    <dt class="label">短信验证码</dt>
                    <dd>
                        <div class="r_input input_auth-code"><input class="" type="text" placeholder="请输入验证码" id="valcode" name="code">
                            <button onclick="sendText()" id="sendvalcode" type="button">发送验证码</button></div>
                    </dd>
                </dl>
                 <br/>
                <dl>
                    <dt class="label">昵称</dt>
                    <dd><input class="r_input input_l" type="name" name="name" placeholder="请输入昵称" id="name">
                         <dd>
                        
                    </dd>
                </dl>
                <br/>
                <dl>
                    <dt class="label">密码</dt>
                    <dd><input class="r_input input_l" type="password" name="password" placeholder="请输入密码" id="password1">
                         <dd>
                        
                    </dd>
                </dl><br/>
                <div class="base_error" id="errPassword" style="display: none;"></div>

                <dl>
                    <dt class="label">确认密码</dt>
                    <dd><input class="r_input input_l" type="password" name="password2"  placeholder="请再次输入密码" id="password2"></dd>
                   
                    <!--输入框报错样式请加上类名input_error-->
                </dl>
                <br/><br/><br/>
                <dl class="form_space">
                    <dt class="label">&nbsp;</dt>
                    <dd><input class="reg_btn" type="submit" value="完成"  id="registerbtn"><br>
                        <a id="pwdQuestionUrl" target="_blank">注册遇到问题？</a></dd>
                </dl>
                </form>
            </div>
            </div>
            <input type="hidden" id="page_id"  value="10320670270"/>
        </div></div>
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

</body>
