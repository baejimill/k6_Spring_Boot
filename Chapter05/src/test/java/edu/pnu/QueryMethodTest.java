package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	
	@Autowired 
	private BoardRepository boardRepo;
	
	@BeforeEach
	public void dataPrepare() {
		for (int i=1; i <=100; i++) {
			Board board = new Board();
			board.setTitle("테스트 제목"+i);
			board.setWriter("테스터");
			board.setContent("테스트 내용"+i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
	}
//	@Test
//	public void tetFinByTitle() {
//		List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");
//		
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+ board.toString());
//		}
//	}
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+ board.toString());
//		}
//	}
//	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("1", "1");
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+ board.toString());
//		}
//	}
//	@Test
//	public void testFindByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList = 
//				boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+ board.toString());
//		}
//	}
//	@Test
//	public void testFindByTitleContaining() {
//		List<Board> boardList = boardRepo.findByTitleContaining("1");
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+ board.toString());
//		}
//	}
//	@Test
//	public void testfindByTitleContainingAndCntGreaterThan() {
//		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50);
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+ board.toString());
//		}
//	}
//	@Test
//	public void testfindByCntBetweenOrderBySeqAsc() {
////		List<Board> boardList = boardRepo.findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc(10,50);
//		List<Board> boardList = boardRepo.findByCntBetweenOrderBySeqAsc(10,50);
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+ board.toString());
//		}
//	}
//	@Test
//	public void testFindByTitleContainingOrContentContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+ board.toString());
//		}
//	}
//	@Test
//	public void testFindByTitleContaining() {
////		Pageable paging = PageRequest.of(0, 5);
//		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC,"seq");
//		List<Board> boardList = boardRepo.findByTitleContaining("제목",paging);
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+ board.toString());
//		}
//	}
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC,"seq");
//		
//		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목",paging);
//		
//		System.out.println("PAGE SIZE : "+ pageInfo.getSize());
//		System.out.println("TOTAL PAGES : "+ pageInfo.getTotalPages());
//		System.out.println("TOTAL COUNT : "+ pageInfo.getTotalElements());
//		System.out.println("NEXT : "+ pageInfo.nextPageable());
//		
//		List<Board> boardList = pageInfo.getContent();
//		
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+ board.toString());
//		}
//	}
	
}


