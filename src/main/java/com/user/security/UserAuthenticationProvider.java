package com.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.main.service.LoginService;
import com.user.UserService;

@Component
public class UserAuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

    @Autowired
    UserService userService;
    
    @Autowired
    LoginService loginService;
    
    
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
    
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		UserDetails userDetails = new UserDetails();
//		테스트
		
		String userId = authentication.getName();
		String userPassword = (String) authentication.getCredentials();
		
		
		if( "".equals(userId)) {
			throw new BadCredentialsException("001");
		}
		
		if( "".equals(userPassword) ) {
			throw new BadCredentialsException("002");
		}
		
		userDetails = loginService.loginChk(userId, userPassword);
		
		//성공 실패시
		if( userDetails == null ) {
			throw new BadCredentialsException("003");
		}
		
		return setSession(userDetails, userId, userPassword);
	}
	
	private UsernamePasswordAuthenticationToken setSession(UserDetails userDetails, String userId, String userPassword ) {
		//사용자정보를 세션에 담는다.
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userId, userPassword);
		
		//비밀번호 삭제 
		userDetails.setUserPassword("");
		
		return result;
		
	}

}
