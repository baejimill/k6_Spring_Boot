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
		Statement st = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from member");

			while (rs.next()) {
				MemberVO m = MemberVO.builder().id(rs.getInt("id")).pass(rs.getString("pass"))
						.name(rs.getString("name")).regidate(rs.getDate("regidate")).build();
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public MemberVO getMemberById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("select * from member where id=?");
			st.setInt(1, id);
			rs = st.executeQuery();

			MemberVO m = null;
			if (rs.next()) {
				m = MemberVO.builder().id(rs.getInt("id")).pass(rs.getString("pass")).name(rs.getString("name"))
						.regidate(rs.getDate("regidate")).build();

			}
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int getaddMember(MemberVO memberVO) {
		PreparedStatement st = null; 
		
		try {
			st = con.prepareStatement("insert into member (pass, name) values (?, ?);");
			st.setString(1, memberVO.getPass());
			st.setString(2, memberVO.getName());
			return st.executeUpdate(); 
			 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int getupdateMember(MemberVO memberVO) {
		PreparedStatement st = null; 
		
		try {
			//퀴리문 템플릿
			String query = "update member set pass=?, name=? where id=?;";
			//퀴리문 완성
			st = con.prepareStatement(query);
			st.setString(1, memberVO.getPass());
			st.setString(2, memberVO.getName());
			st.setInt(3, memberVO.getId());
			return st.executeUpdate();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int getremoveMember(Integer id) {
		PreparedStatement st = null;
		
		try {
			//퀴리문 템플릿
			String query = "delete from member where id=?;";
			
			//퀴리문 완성
			st = con.prepareStatement(query);
			st.setInt(1, id);
			
			return st.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
			
		}
		return 0;
	}
}