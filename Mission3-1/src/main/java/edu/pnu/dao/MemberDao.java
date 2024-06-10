package edu.pnu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class MemberDao {

	private final DataSource dataSource;

	private MemberVO getMemberVO(ResultSet rs) throws SQLException {
		
			return MemberVO.builder().id(rs.getInt("id")).pass(rs.getString("pass")).name(rs.getString("name"))
					.regidate(rs.getDate("regidate")).build();
			
	}

	public MemberVO getMemberById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = dataSource.getConnection().prepareStatement("select * from member where id=?");
			st.setInt(1, id);
			rs = st.executeQuery();

			MemberVO m = null;
			if (rs.next()) {
				m = getMemberVO(rs);
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

	public MemberVO getaddMember(MemberVO memberVO) {

		return null;
	}

	public List<MemberVO> getAllMembers() {
		// TODO Auto-generated method stub
		return null;
	}

}
