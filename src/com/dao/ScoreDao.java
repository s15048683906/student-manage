package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.beans.ScoreInfo;
import com.jdbc.DBUtil;
import com.jdbc.MyBatisUtil;

public class ScoreDao {
	//���ݸ���id����ѯ���¼����࣬���parentidΪ0����ѯ����һ������
	public List<ScoreInfo> getSubScoreList(int parentId){
		SqlSession s=MyBatisUtil.getSession();
		List<ScoreInfo> scoreList=s.selectList("score.getSubScoreList",parentId);
		for(ScoreInfo score:scoreList) {
			if(score.getParentId()==0) {
				score.setSubScoreList(getSubScoreList(score.getId()));
			}
		}
		s.close();
		return scoreList;
	}
	
	//��ӷ���
	public int add(ScoreInfo score) {
		SqlSession s= MyBatisUtil.getSession();
		int result=s.insert("score.add",score);
		s.commit();
		s.close();
		return result;
	}

	//��ѯ���з���
	public List<ScoreInfo> getAllScore() {
		List<ScoreInfo> scoreList=new ArrayList<ScoreInfo>();
		
		Connection conn=null;
		PreparedStatement stm=null;
		ResultSet rs=null;

		try {
			conn=DBUtil.getConn();
			String sql="select * from ScoreInfo";
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()) {
				ScoreInfo score=new ScoreInfo();
				score.setId(rs.getInt("id"));
				score.setName(rs.getString("name"));
				
				scoreList.add(score);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stm, conn);
		}

	    return scoreList;
	}

	public ScoreInfo getScoreById(int id) {
		SqlSession s=MyBatisUtil.getSession();
		ScoreInfo score=s.selectOne("score.getScoreById",id);
		s.close();
		return score;
	}


}
