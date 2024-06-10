package edu.pnu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberController {
	
//	@Autowired
	private final MemberService memberService;
	
	
//	public MemberController(MemberService memberService) throws SQLException{
//		this.memberService = memberService;
		
//		System.out.println("MemberController 생성");
//		memberService = new MemberService();
//		memberService.setMemberDao(new MemberDao());
//	}
	
	@GetMapping("/members")
	public ResponseEntity<?> getAllMember() {
		return ResponseEntity.ok(memberService.getAllMember());
	}
	
	@GetMapping("/member")
	public MemberVO getMemberById(Integer id) {
		return memberService.getMemberById(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		return memberService.addMember(memberVO);
	}
	
}

