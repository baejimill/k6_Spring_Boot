package edu.pnu.config.filter;

import java.io.IOException;
import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.pnu.domain.Member;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	// 인증 객체
	private final AuthenticationManager authenticationManager;

	// POST/login 요청이 왔을 때 인증을 시도하는 메소드
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// request에서 json 타입의 [username/password]를 읽어서 Member 객체를 생성한다.
		ObjectMapper mapper = new ObjectMapper();
		Member member = null;
		try {
			member = mapper.readValue(request.getInputStream(), Member.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
// Security에게 로그인 요청에 필요한 객체 생성  인증요청을 위한 객체!
		Authentication authToken = new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword());

// 인증 진행 -> UserDetailsService를 상속받은 클래스의 loadUserByUsername 호출한다.
		Authentication auth = authenticationManager.authenticate(authToken);
		System.out.println("auth:" + auth);

		return auth; //null을 리턴한다

	}

// 인증이 성공했을 때 실행되는 후처리 메소드 로그인을 성골했을떄 토근을 만든다.
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		//인증 결과 생성된  Atthentication 객체에서 필요한 정보를 읽어서 토큰을 만들어서 헤더에 추가한다.
		User user = (User)authResult.getPrincipal();
		//jwt 토큰
		String token = JWT.create()
						.withExpiresAt(new Date(System.currentTimeMillis()+1000*60*100))
						.withClaim("username", user.getUsername())
						.sign(Algorithm.HMAC256("edu.pnu.jwt"));
		response.addHeader("Authorization", "Bearer " + token);

		
		//super.successfulAuthentication(request, response, chain, authResult);
	}

}