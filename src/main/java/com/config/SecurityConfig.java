package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.user.security.UserAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	/**
	 * 커스텀 인증 구현 클래스
	 */
	@Autowired
	private UserAuthenticationProvider authenticationProvider;
	
	/**
	 * 시큐리티 호출관련 기본 선언
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		//	호출 경로별 권한 체크
		http.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/image/**").permitAll()
				.antMatchers("/user/**").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN");					//	관리자페이지 권한부여
		
				//	선언하지 않은 경로는 인증된 사용자만 허용 사용할지 설정
//				.anyRequest().authenticated()
		
		//	로그인
		http.formLogin()
				.loginPage("/login")
				.usernameParameter("userId")
				.passwordParameter("passWord")
				.loginProcessingUrl("/loginRequest")
				.successForwardUrl("/home")
				.failureUrl("/login?error")
				.permitAll();
		
		//	로그아웃
		http.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true)
				.permitAll();
	}
	
	/**
	 * 커스텀 방식을 이용하여 인증하기 위해 Provider선언
	 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
}
