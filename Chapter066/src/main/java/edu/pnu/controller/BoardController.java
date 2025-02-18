package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import edu.pnu.domain.Board;


@Controller
public class BoardController {

	@GetMapping("/getBoardList")
	public String getBoardList(Model model) {
		List<Board> boardList = new ArrayList<Board>();
		
		for(int i=1 ; i<=10 ; i++) {
			Board board = new Board();
			board.setSeq(Long.valueOf(i));
			board.setTitle("게시판 프로그램 테스트");
			board.setWriter("도우너");
			board.setContent("게시판 프로그램 테스트입니다");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardList.add(board);
			
		}
		model.addAttribute("boardList",boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	
	
}

