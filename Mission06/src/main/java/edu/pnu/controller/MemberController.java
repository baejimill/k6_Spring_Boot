package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/members")
	public List<Member> getAllMember() {
		return memberService.getAllMember();
	}
	@GetMapping("/member")
	public Member getMemberById(String username) {
		return memberService.getMemberById(username);
	}
	
	@PostMapping("/member")
	public Member addMember(Member member) {
		return memberService.addMember(member);
	}
	
	@PutMapping("member")
	public Member updateMember(Member member) {
		return memberService.updateMember(member);
	}
	@DeleteMapping("/member")
	public Member deletMember(String username) {
		return memberService.deletMember(username);
	}
}
