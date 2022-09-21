package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.beans.MemberInfo;
import com.jdbc.DBUtil;

public class MemberDao {
	
	 //查询所有用户 
		public List<MemberInfo> getAllMembers() {
			List<MemberInfo> memberList=new ArrayList<MemberInfo>();
			
			Connection conn=null;
			PreparedStatement stm=null;
			ResultSet rs=null;

			try {
				conn=DBUtil.getConn();
				String sql="select * from memberInfo";
				stm=conn.prepareStatement(sql);
				rs=stm.executeQuery();
				while(rs.next()) {
					MemberInfo member=new MemberInfo();
					member.setMemberNo(rs.getString("memberNo"));
					member.setMemberName(rs.getString("memberName"));
					member.setPhone(rs.getString("phone"));
					member.setEmail(rs.getString("email"));
					member.setRegisterDate(rs.getString("registerDate"));
					member.setMemberLevel(rs.getString("memberLevel"));
					
					memberList.add(member);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUtil.close(rs, stm, conn);
			}

			return memberList;
		}

}
