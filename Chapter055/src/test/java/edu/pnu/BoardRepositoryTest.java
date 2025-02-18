package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import jakarta.transaction.Transactional;


@SpringBootTest
@Transactional
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	@Transactional
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("첫번째 게시글");
		board.setWriter("테스터");
		board.setContent("잘 등록되나요?");
		board.setCreateDate(new Date());
		board.setCnt(0L);
		
		boardRepo.save(board);
	}
}
