package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardRepository boardRepo;
	
	public List<Board> getBoardList(Board board){
		return (List<Board>) boardRepo.findAll();
	}
	
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	
	public Board getBoard(Board board) {
		return null;
	}
	
	public void updateBopard(Board board) {
		
	}
	
	public void deleteBoard(Board board) {
		
	}
}
