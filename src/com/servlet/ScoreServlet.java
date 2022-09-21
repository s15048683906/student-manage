package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.ScoreInfo;
import com.dao.ScoreDao;

@WebServlet("/ScoreServlet")

public class ScoreServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ScoreDao scoreDao=new ScoreDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");

		if("add".equals(flag)) {
			add(request,response);
		}
		else if("manage".equals(flag)){
			manage(request,response);
		}

	}


	//根据父子级关系，显示商品分类维护界面
	private void manage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int parentId=0;
		List<ScoreInfo> scoreList=scoreDao.getSubScoreList(parentId);
		request.setAttribute("scoreList", scoreList);
		request.getRequestDispatcher("/score/score_manage.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courseId=Integer.parseInt(request.getParameter("courseId"));
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String score=request.getParameter("score");
		
		ScoreInfo Score=new ScoreInfo();		
		Score.setParentId(courseId);
		Score.setId(id);
		Score.setName(name);
		Score.setScore(score);
		
		int result=scoreDao.add(Score);
		if(result==1) {
			request.setAttribute("msg", "班级添加成功");
			request.getRequestDispatcher("/score/score_add.jsp").forward(request, response);;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				doGet(request, response);
	}
	
}
