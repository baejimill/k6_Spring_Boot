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
				.username("username1").password("password1").role("USER").build();
		memberRepo.save(m1);
		
		Member m2 = Member.builder()
				.username("username2").password("password2").role("ANDA").build();
				memberRepo.save(m2);
		
		for (int i=1; i<5; i++) {
			boardRepo.save(Board.builder()
					.title("title1"+i).content("content1"+i)
					.seq((long)(Math.random()*100))
					.member(m1)
					.build());
		}
	}
}
