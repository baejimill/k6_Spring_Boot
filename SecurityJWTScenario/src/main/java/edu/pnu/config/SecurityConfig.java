package edu.pnu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

import edu.pnu.config.filter.JWTAuthenticationFilter;
import edu.pnu.config.filter.JWTAuthorizationFilter;
import edu.pnu.persistence.MemberRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;
	@Autowired
	private MemberRepository memberRepository;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf->csrf.disable()); //CSRF 보호 비활성화
		
		http.authorizeHttpRequests(auth->auth
				.requestMatchers("/public/**").authenticated()
				.requestMatchers("/intra/marketing/**").hasAnyRole("MARKETING","ADMIN")
				.requestMatchers("/intra/develop/**").hasAnyRole("DEVELOP","ADMIN")
				.requestMatchers("/intra/finance/**").hasAnyRole("FINANCE","ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN"));
				
		
		http.formLogin(frmLogin->frmLogin.disable());  //Form을 이용한 로그인울 사용하지 않겠다는 설
		http.httpBasic(basic->basic.disable());        //Http Basic인증 방식을 사용하지 않겠다는 설정
		
		//세션을 유지하지 않겠다고 설정 -> URL 호출 뒤 응답할 때 까지는 유지되지만 응답 후 삭제된다는 의미.
		http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//스프링 시큐리티가 등록한 필터체인의 뒤에 작성한 필터를 추가한다.
		http.addFilter(new JWTAuthenticationFilter(
												authenticationConfiguration.getAuthenticationManager()));
		//스프링 시큐리티가 등록한 필터들 중에서 AuthorizationFilter 앞에 앞에서 작성한 필터를 삽입한다.
		http.addFilterBefore(new JWTAuthorizationFilter(memberRepository), AuthorizationFilter.class);
		
		return http.build();
	}
}
