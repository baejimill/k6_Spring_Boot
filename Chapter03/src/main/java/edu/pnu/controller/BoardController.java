package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BoardController {
	
	@GetMapping("/hello")
	public String hello(String name) {
		log.info("name"+name);
		System.out.println("name" + name);
		
		return "Hello : " + name;
	}
	
	@GetMapping("/getboard")
	public BoardVO getBoard() {
		BoardVO boardVO = new BoardVO();
		boardVO.setWriter("테스터");
		return boardVO;
	}
}
