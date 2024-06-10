package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import eud.pnu.persistence.MemberRepository;

@SpringBootTest
public class MemberInitalize {

	@Autowired
	private MemberRepository memRepo;   //Table Member CRUD 인터페이스
	
	PasswordEncoder encoder = new BCryptPasswordEncoder();  //ㅣ비밀번호 암호화 인터페이스/구현체
	
	@Test
	public void doWork() {
		memRepo.save(Member.builder()
				.username("member")
				.password(encoder.encode("qwer"))
				.role(Role.ROLE_MEMBER)
				.enabled(true).build());
		memRepo.save(Member.builder()
				.username("manager")
				.password(encoder.encode("qwer"))
				.role(Role.ROLE_MANAGER)
				.enabled(true).build());
		memRepo.save(Member.builder()
				.username("admin")
				.password(encoder.encode("qwer"))
				.role(Role.ROlE_ADMIN)
				.enabled(true).build());
	}
}
