package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BoardVO;

@RestController
public class BoardController {

	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	@GetMapping("/hello") //호스트를 찾음
	public String hello(String name) {
		return "Hello : " +name;
	}
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 제목...");
		board.setWrite("테스터");
		board.setContent("테스트 내용입니다..............");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board;
	}
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList  = new ArrayList<BoardVO>();
		for (int i = 1; i <= 10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("제목"+i);
			board.setWrite("테스터");
			board.setContent(i + "번 내용입니다.");
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}
}
