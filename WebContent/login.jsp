<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link rel="stylesheet" type="text/css" href="css/login.css" ></link>
	
  </head>
  
  <body>
 	   <div id="div_center">
 	   	  <form action="Adminservlet" method="post">
 	   	  		<input name="flag" value="login" type="hidden" >
 	   	  		 
				<div id="div_inputbox">
					<input type="text" id="adminName" name="adminName" value="admin" />
					<input type="password" id="password" name="password" value="123" />
				</div>
				<input id="btn_img" type="image" src="images/bg_login_btn.jpg" />
		   </form>
 	   </div>
 	   
 	   <script>
 	   	 var str="${msg }";
 	   	 if(str!=""){
 	   		 alert(str);
 	   	 }
 	   </script>
  </body>
</html>
