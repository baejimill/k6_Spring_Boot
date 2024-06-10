package edu.pnu.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;
@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public void login() {
		System.out.println("login 요청");
	}
	@GetMapping("/loginSuccess") 
	public void loginsuccess() {
		System.out.println("loginSuccess 요청입니다.");
	}
	@GetMapping("/accessDenied")
	public void accessDenied() {
		System.out.println("accessDenied");
	}
	// 로그인 세션 정보 확인용 URL
	@GetMapping("/auth")
	public @ResponseBody ResponseEntity<?> auth(@AuthenticationPrincipal User user) {
		
		if (user == null) {
			return ResponseEntity.ok("로그인 상태가 아닙니다.");
		}
		return ResponseEntity.ok(user);   
	}
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public String joinProc(Member member) {
		memberService.save(member);
		return "welcome";
	}
}
