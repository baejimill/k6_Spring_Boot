package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	public MemberService(MemberDao memberDao2) {
		// TODO Auto-generated constructor stub
	}

	public List<MemberVO> getAllMember() {
		return memberDao.getAllMember();
	}
	
	public MemberVO getMemberById(Integer id) {
		return memberDao.getMemberById(id);
	}

	public MemberVO addMember(MemberVO memberVO) {
		return memberDao.getaddMember(memberVO);
	}
}
