<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<script type="text/javascript">
		$(function(){
			$("#ch_checkall,#top_ch_checkall").click(function(){
				if(this.checked){
					$("input[name=ck_id]").attr("checked","checked");
				}else{
					$("input[name=ck_id]").removeAttr("checked");
				}		
			});
					
			$("table tr").mouseover(function(){
				$(this).css("background","#D3EAEF");
				$(this).siblings().css("background","white");
			});
		});
	</script>

	<link rel="stylesheet" type="text/css" href="css/maintable.css" ></link>
	<style>
    	.div_tools{
    		width:99.5%; 
			height:28px;
			background:#D3EAEF;
			margin:0px auto;
			margin-top:5px;
			margin-bottom:5px;
			font-size:12px;
			padding-top:5px;
			position:relative;	
    	}
    	
    	.div_tools select{
    		height:22px;
    		font-size:12px;
			margin-top:3px;
    	}
    	
    	#btnsubmit{
    		width:40px;
    		height:20px;
    		font-size:12px;
    	}
    	
    </style>
  </head>
  
  <body>
  
	  <div class ="div_title">
			<div class="div_titlename"> <img src="images/san_jiao.gif" ><span>学生信息</span></div>
			<div class="div_titleoper">
			<input type="checkbox" id="top_ch_checkall"/> 全选 <a href="student/student_add.jsp"> <img src="images/add.gif"/>添加 </a> <a href="javascript:void(0)"><img src="images/del.gif"/>删除</a> </div>
	  </div>
	  <form action="StudentServlet">
	  	<input type="hidden" value="manage" name="flag">
	  	<div class="div_tools">
	     	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	     	请输入学号：<input type="text" name="id" value="" /></input>
  	     	&nbsp;<input id="btnsubmit" type="submit" value="查询"/>
  	     </div>
 
  	  <table  class="main_table">
  		<tr>
  		    <th><input type="checkbox" id="ch_checkall" /></th>
  			<th>学号</th>
  			<th>密码</th>
  			<th>姓名</th>
  			<th>性别</th>
  			<th>专业</th>
  			<th>班级</th>
  			<th>操作</th>
  		</tr>
  		
  		<c:forEach var="student"  items="${studentList}"    >
	  		<tr>
	  		    <td>
					 <input type="checkbox" name="ck_id" value="${student.id}" /> 
				</td>
	  			<td>${student.id }</td>
	  			<td>${student.password }</td>
	  			<td>${student.studentName }</td>
	  			<td>${student.sex }</td>
	  			<td>${student.major }</td>
	  			<td>${student.class_ }</td>
	  			<td>
		      		<a href="StudentServlet?flag=searchForUpdate&id=${student.id}" >修改</a>  
		     		 |  <a href="StudentServlet?flag=delete&id=${student.id }" onclick="return confirm('确定要删除吗')" >删除</a>
           		</td>
	  		</tr>	
  		</c:forEach>	
  	</table>
  	<div class="div_page" >
					  <div class="div_page_left">    共有 <label>3</label> 条记录，当前第 <label>1</label> 页，共 <label>1</label> 页	</div>

					  <div class="div_page_right" > 	 						  		
						  			 首页
					  	 			 上一页
					  	 			 
						  			下一页 
					  	 		         尾页
						  	 <button onclick="javascript:void(0)">转到</button>
						  	 <input type="text" name="pageIndex" id="pageIndex" value="1" /> 页
					  	
					   </div>
		  </div>
	</form>
	  <script>
 	   	 var str="${msg }";
 	   	 if(str!=""){
 	   		 alert(str);
 	   	 }
 	   </script>
 
  </body>
</html>
