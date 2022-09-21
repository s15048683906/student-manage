package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.beans.Class_Info;
import com.jdbc.DBUtil;
import com.jdbc.MyBatisUtil;

public class Class_Dao {
	//根据父级id，查询其下级分类，如果parentid为0，查询所有一级分类
	public List<Class_Info> getClass_List(int parentId){
		SqlSession s=MyBatisUtil.getSession();
		List<Class_Info> class_List=s.selectList("class_.getClass_List",parentId);
		for(Class_Info class_:class_List) {
			if(class_.getParentId()==0) {
				class_.setSubClass_List(getClass_List(class_.getId()));
			}
		}
		s.close();
		return class_List;
	}
	
	//添加分类
	public int addClass_(Class_Info class_) {
		SqlSession s= MyBatisUtil.getSession();
		int result=s.insert("class_.addClass_",class_);
		s.commit();
		s.close();
		return result;
	}

	//查询所有分类
	public List<Class_Info> getAllCate() {
		List<Class_Info> cateList=new ArrayList<Class_Info>();
		
		Connection conn=null;
		PreparedStatement stm=null;
		ResultSet rs=null;

		try {
			conn=DBUtil.getConn();
			String sql="select * from class_Info";
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()) {
				Class_Info class_=new Class_Info();
				class_.setId(rs.getInt("id"));
				class_.setClass_Name(rs.getString("class_Name"));
				
				cateList.add(class_);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stm, conn);
		}

	    return cateList;
	}

	public Class_Info getClass_ById(int id) {
		SqlSession s=MyBatisUtil.getSession();
		Class_Info class_=s.selectOne("class_.getClass_ById",id);
		s.close();
		return class_;
	}

	public int deleteClass_ById(int id) {
		SqlSession s=MyBatisUtil.getSession();
		int result=s.delete("class_.deleteClass_ById",id);
		s.commit();  	
		s.close();
		return result;	
	}

}
