package eud.pnu.config.filter;

import java.io.IOException;

import javax.naming.AuthenticationException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	//인증 객체
	private final AuthenticationManager authenticationManager;
	
	//POST/login 요청이 왔을 떄 인증을 시도하는 메소드
	@Override
	public Authentication attemotAuthentication(HttpServletRequest request,
								HttpServletResponse response) throws AuthenticationException {
		//request에서 json 타입의 [username/password]를 읽어서 Member 객체를 생성한다.
		ObjectMapper mapper = new ObjectMapper();
		return super.attemptAuthentication(request, response);
	}
	//인증이 성공했을떄 실행되는 후처리 메소드
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse
			response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
			super.successfulAuthentication(request, response, chain, authResult);
		}
}
	


