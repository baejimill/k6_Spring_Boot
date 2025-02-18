package edu.pnu.persistence;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	List<Board> findByTitle(String searchKeyword);
	
	List<Board> findByContentContaining(String searchKeyword);  //searchKeyword가 뭐지 그냉 다 통틀어서 검색한다는건가
	
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	List<Board> findByTitleContaining(String title);
	
	List<Board> findByTitleContainingAndCntGreaterThan(String title, int cnt);  //3번
	
//	List<Board> findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc(int cnt1,int cnt2); //같은 4번
	
	List<Board> findByCntBetweenOrderBySeqAsc(int cnt1, int cnt2); //4번
	
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);  //5번
	
//	List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
//	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchKeyword);
	
//	@Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(@Param("searchKeyword")String searchKeyword);
	
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b "
//			+ "WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Object[]> queryAnnotationTest2(@Param("searchKeyword")String searchKeyword);
	
	@Query(value = "select seq, title, writer, create_date "
					+ "from board where title like '%'||?1||'%' "
					+ "order by seq desc", nativeQuery = true)
	List<Object[]> queryAnnotationTest3(String searchKeyword);
	
	
	
	
	

	
}
