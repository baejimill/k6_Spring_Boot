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
class SpringBootSecuritsyJwt1ApplicationTests {
@Autowired
MemberRepository memRepo;

PasswordEncoder encoder = new BCryptPasswordEncoder();
	@Test
	void contextLoads() {
		memRepo.save(Member.builder()
				.username("member")
				.password(encoder.encode("qwer"))
				.role(Role.ROLE_MEMBER)
				.enabled(true).build());
	}

}
