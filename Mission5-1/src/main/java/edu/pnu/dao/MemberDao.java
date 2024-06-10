package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDao {
	
		private Connection con;
		
		public MemberDao() {
			
			try {
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/mission", "sa", "abcd");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> getAllMember() {
		Statement st =null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from member");
			
			while (rs.next()) {
				MemberVO m = MemberVO.builder()
						.id(rs.getInt("id"))
						.pass(rs.getString("pass"))
						.name(rs.getString("name"))
						.regidate(rs.getDate("regidate"))
						.build();
				
//				MemberVO m1 = new MemberVO();
//				m1.setId(rs.getInt("id"));
//				m1.setPass(rs.getString("pass"));
//				m1.setName(rs.getString("name"));
//				m1.setRegidate(rs.getDate("regidate"));
				
				list.add(m);
			}
		}catch (SQLException e) {
			e.printStackTrace();
	} finally {
		try {
			if (st != null) st.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 	return list;
	}

	public MemberVO getMemberById(Integer id) {
		PreparedStatement st =null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("select * from member where id=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			MemberVO m = null;
			if (rs.next()) {
				 m = MemberVO.builder()
						.id(rs.getInt("id"))
						.pass(rs.getString("pass"))
						.name(rs.getString("name"))
						.regidate(rs.getDate("regidate"))
						.build();
				
			}
			return m;
		}catch (SQLException e) {
			e.printStackTrace();
	} finally {
		try {
			if (st != null) st.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 	return null;
	}

	public MemberVO getaddMember(MemberVO memberVO) {
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		try {
//			st = con.prepareStatement("insert into member (pass, name) values (‘?’, ‘?’);");
//			st.setInt(1, pass);
//			st.setInt(2, name);
//			rs = st.executeQuery();
//			
//			MemberVO m = null;
//			if (getMemberById(memberVO.getId()) != null) 
//				return null;
//			memberVO.setRegidate((new Date()));
//				m.add(memberVO);
//				return memberVO;
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
		return null;
	}
	
}
