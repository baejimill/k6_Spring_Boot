package edu.pnu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component

public class DataInit implements ApplicationRunner{
	
	private final BoardRepository boardRepo;
	private final MemberRepository memberRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {	

		Member m1 = Member.builder()
				.id("member1").password("qwer").name("홍길동")
				.role("USER").build();
		memberRepo.save(m1);
		
		Member m2 = Member.builder()
				.id("member2").password("qwer").name("홍이동")
				.role("ADMIN").build();
		memberRepo.save(m2);
		
		for (long i=1L; i<=10L; i++) {
			boardRepo.save(Board.builder()
					.title("title1"+i).writer("member1")
					.content("content1"+i).build());
		}
		
		for (long i=1L; i<=10L; i++) {
			boardRepo.save(Board.builder()
					.title("title2"+i).writer("member2")
					.content("content2"+i).build());
		}
	}
}
