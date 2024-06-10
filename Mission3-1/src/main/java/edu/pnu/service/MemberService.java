package edu.pnu.service; 

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MemberService {
//	@Autowired
	private final MemberDao memberDao;
	
//	public void setMemberDao(MemberDao memberDao2) {
//		// TODO Auto-generated method stub
//		this.memberDao = memberDao;
//	}
//	public MemberService() {
//		System.out.println("MemberService생성");
//		memberDao = new MemberDao();
//	}
	
	public List<MemberVO> getAllMember() {
		return memberDao.getAllMembers();
	}
	
	public MemberVO getMemberById(Integer id) {
		return memberDao.getMemberById(id);
	}

	public MemberVO addMember(MemberVO memberVO) {
		return memberDao.getaddMember(memberVO);
	}

}
