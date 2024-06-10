package edu.pnu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import lombok.Delegate;

@RestController
public class MemberController {
	
	MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService(); //memberService가 참조변수이다!
	}

	@GetMapping("/members")
	public List<MemberVO> getAllMember(){
		return memberService.getAllMember();
	}
	
	@GetMapping("/member")
	public MemberVO getMemberById(Integer id) {
		return memberService.getMemberById(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
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