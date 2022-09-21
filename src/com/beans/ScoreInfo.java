package com.beans;

import java.util.List;

public class ScoreInfo {
	
	private int id;  
	private String name;     
	private String score;     
	private int parentId;  
	private List<ScoreInfo> subScoreList;//该分类下的子分类
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public List<ScoreInfo> getSubScoreList() {
		return subScoreList;
	}
	public void setSubScoreList(List<ScoreInfo> subScoreList) {
		this.subScoreList = subScoreList;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
}