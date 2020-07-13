package com.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.user.UserService;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;
    
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userId = authentication.getName();
		String passWord = (String) authentication.getCredentials();
		
		//	사용자 객체 사용??
		if(userId.equals("")) {
//			throw new AuthenticationException
		}
		
		//	인증 토큰 생성
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
