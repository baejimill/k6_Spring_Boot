package edu.pnu.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

@RestController
public class MemberController {
	private List<MemberVO> list = new ArrayList<>();
	
	public MemberController() {
		for (int i = 1; i <=10; i++) {
			list.add(MemberVO.builder()
					.id(i).name("name"+i)
					.pass("pass"+i)
					.regidate(new Date())
					.build());
		}
	}
	//검색(Read - select)
	@GetMapping("/members")
	public ResponseEntity<?> getAllMember() {
		return ResponseEntity.ok(list);
	}
	//검색(Read - select)
	@GetMapping("/member")
	public MemberVO getMemberById(Integer id) {
		 for (MemberVO m : list) {
			 if (m.getId() == id)
				 return m;
		 }
		 return null;
	}
	//입력(Create - insert)
	@PostMapping("/member")
	public MemberVO addMember (MemberVO memberVO) {
		if (getMemberById(memberVO.getId()) !=null)
			return null;
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return memberVO;
	}
	@PostMapping("/memberJSON")
	public MemberVO addMemberJSON(@RequestBody MemberVO memberVO) {
	return addMember(memberVO);
	}

	
}
