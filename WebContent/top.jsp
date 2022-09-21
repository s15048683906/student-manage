<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
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
	
	<link rel="stylesheet" type="text/css" href="css/top.css" ></link>
	<script type="text/javascript" src="js/jquery-1.8.0.js"></script>  

  </head>
  
  <body>
  
    <table id="t_head">
   		 <tr>
   			<td id="td1" ></td>
   			<td id="td2">&nbsp;</td>
   			<td id="td3">
   				<a id="td3_a1"  target="centerFrame" href="/admin/password_edit.jsp"><img src="images/btn_head_bg1.jpg"/>修改密码</a>
   				<a  target="centerFrame" href="admin/admin_info.jsp"><img src="images/btn_head_bg1.jpg"/>用户信息</a>
   				<a href="Adminservlet?flag=logout" onclick="return confirm('确定注销退出吗')"><img src="images/btn_head_bg1.jpg"/>退出系统</a>
   			</td>   
   	     </tr>
    </table>
    <table id="t_bar" >
			<tr>
					<td id="bar_td1"></td>
					<td id="bar_td2">
						<div id="div_date">
						<%
							Date d=new Date();
							String str=new SimpleDateFormat("yyy-MM-dd E hh:mm").format(d);
							out.print(str);
						%>
						</div>
					</td>
					
				<td id="bar_td3">
				学生信息综合管理系统</td>
			
			</tr>
    </table>
	<table id="t_title">
			<tr>
				<td id="title_td1">
						<img src="images/main_28.gif"/>
				</td>	
				<td id="title_td2"><img src="images/main_29.gif" /></td>	
				<td id="title_td3"><img src="images/main_30.gif" /></td>	
				<td id="title_td4">&nbsp;
						<label class="admininfo">当前登录用户: ${g_admin.adminName} 用户状态  : ${g_admin.state}
					</label>
				</td>	
				<td id="title_td5"><img src="images/main_32.gif" /></td>
			</tr>
	</table>
	
  </body>
</html>
