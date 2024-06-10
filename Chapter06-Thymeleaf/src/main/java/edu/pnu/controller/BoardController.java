package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.service.BoardService;
@SessionAttributes("member")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/getBoardList")
	public String getBoardList(@ModelAttribute("member")Model model, Board board, Member member) {
		if (member.getId() == null) {
			return "redirect:login";
		}
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList",boardList);
		return "getBoardList";
	}
	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Board board, Member member) {
		if (member.getId() == null) {
			return "redirect:login";
		} 
		return "insertBoard";
	}
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Board board, Member member) {
		if (member.getId() == null) {
			return "redirect:login";
		}  
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Board board, Member member, Model model) {
		if (member.getId() == null) {
			return "redirect:login";
		} 
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}

	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member") Board board, Member member) {
		if (member.getId() == null) {
			return "redirect:login";
		} 
		boardService.updateBoard(board);
		return "redirect:getBoardList";
	}
	@GetMapping("/deletBoard")
	public String deletBoard(@ModelAttribute("member") Board board, Member member) {
		if (member.getId() == null) {
			return "redirect:login";
		} 
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}
	
}
