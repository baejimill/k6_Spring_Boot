package edu.pnu.config.filter;







import java.io.IOException;
import java.util.Date;

import org.springframework.http.HttpStatus;
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
	
	private final AuthenticationManager authenticationManager;
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse
			response) throws AuthenticationException {
			// request에서 json 타입의 [username/password]를 읽어서 Member 객체를 생성한다.
			ObjectMapper mapper = new ObjectMapper();
			Member member = null;
			try {
			member = mapper.readValue(request.getInputStream(), Member.class);
			} catch (Exception e) {
			e.printStackTrace();
			}
			// Security에게 로그인 요청에 필요한 객체 생성
			Authentication authToken = new UsernamePasswordAuthenticationToken(member.getUsername(), 
			member.getPassword());
			// 인증 진행 -> UserDetailsService를 상속받은 클래스의 loadUserByUsername 호출한다.
			Authentication auth = authenticationManager.authenticate(authToken);
			System.out.println("auth:" + auth);
			return auth;
			}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain, Authentication authResult) throws IOException, ServletException {
		
		User user = (User)authResult.getPrincipal();
		
		String token = JWT.create()
						.withExpiresAt(new Date(System.currentTimeMillis()+1000*60*100))
						.withClaim("username", user.getUsername())
						.sign(Algorithm.HMAC256("edu.pnu.jwt"));
		response.addHeader("Authorization","Bearer" + token);
		response.setStatus(HttpStatus.OK.value());
	}
}
