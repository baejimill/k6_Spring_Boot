package edu.pnu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}
	
//	public MemberController() throws SQLException{
//		memberService = new MemberService(new MemberDao());
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
	public int addMember(MemberVO memberVO) {
		return memberService.addMember(memberVO);
	}
	
	@PutMapping("/member")
	public int updateMember(MemberVO memberVO) {
		return memberService.updateMember(memberVO);
	}
	@DeleteMapping("/member")
	public int removeMember(Integer id) {
		return memberService.removeMember(id);
	}
}

