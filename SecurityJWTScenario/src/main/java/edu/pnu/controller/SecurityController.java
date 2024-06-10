package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SecurityController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/public")
	public String public1() {
		return "public";
	}
	@GetMapping("/marketing")
	public String marketing() {
		return "marketing";
	}
	@GetMapping("/devlop")
	public String devlop() {
		return "devlop";
	}
	@GetMapping("/finance")
	public String finance() {
		return "finance";
	}
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
