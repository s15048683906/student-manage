<%@ page language="java" import="java.util.*,com.beans.*,com.dao.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	 
	<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
	<script type="text/javascript" src="js/jquery.easing.js"></script>
	<script type="text/javascript" src="js/jquery.accordion.js"></script>
			
	<script type="text/javascript">
		$(function(){
			$('#navigation').accordion({
				active:1,   /* 第三个被激活 */
				header: '.head',
				/*navigation1: false,  */
				event: 'click',
				fillSpace: true,
				animated: 'bounceslide'   /*slide,bounceslide ,bounceslide,easeslide'*/
			});
		});
	</script>
	<link rel="stylesheet" type="text/css" href="css/menu.css">

  </head>
  
  <body>
	  <%
	     AdminInfo admin=(AdminInfo)session.getAttribute("g_admin");
	     int roleId=admin.getRoleId();
	     List<MenuInfo> menuList=new MenuDao().getMenuList(0,roleId);
	     request.setAttribute("menuList",menuList);
	  %>
		  <ul id="navigation">
		  	<c:forEach var="menu" items="${menuList }">
		  		<li>
			  		<a class="head" > ${menu.menuName }</a>
			  		<ul>
			  			<c:forEach var="m_sub" items="${menu.subMenuList }">
			  				<li>
			  					<a href="${m_sub.url }" target="${m_sub.target }" > <img src="images/${m_sub.icon }"><label>${m_sub.menuName }</label></a>
			  				</li>
			  			</c:forEach>
			  		</ul>
		  		</li>
		  	</c:forEach>
		  </ul>
	
  </body>
</html>
