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
	 * Ŀ���� ���� ���� Ŭ����
	 */
	@Autowired
	private UserAuthenticationProvider authenticationProvider;
	
	/**
	 * ��ť��Ƽ ȣ����� �⺻ ����
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		//	ȣ�� ��κ� ���� üũ
		http.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/image/**").permitAll()
				.antMatchers("/user/**").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN");					//	������������ ���Ѻο�
		
				//	�������� ���� ��δ� ������ ����ڸ� ��� ������� ����
//				.anyRequest().authenticated()
		
		//	�α���
		http.formLogin()
				.loginPage("/login")
				.usernameParameter("userId")
				.passwordParameter("passWord")
				.loginProcessingUrl("/loginRequest")
				.successForwardUrl("/home")
				.failureUrl("/login?error")
				.permitAll();
		
		//	�α׾ƿ�
		http.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true)
				.permitAll();
	}
	
	/**
	 * Ŀ���� ����� �̿��Ͽ� �����ϱ� ���� Provider����
	 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
}
