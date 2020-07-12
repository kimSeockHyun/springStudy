package com.main.service;


import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.Users;
import com.user.repository.UserRepository;
import com.util.UserPasswordHashUtil;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	
	public String login(String userId, String userPwd) {
		
//		String rtnPage = "";
		
		if( "".equals(userId) || "".equals(userPwd) ) {
			return "login";
		}
		
		UserPasswordHashUtil hashUtil = new UserPasswordHashUtil();
		String hash512 = hashUtil.getSHA512(userPwd);
		
		Users userInfo  = userRepository.findByUserIdAndUserPw(userId, hash512);
		
		Optional<Users> optUser = Optional.ofNullable(userInfo);
		if(!optUser.isPresent()) {
			
			
			
			return "login";
		}
		
		/*
		 * Optional
		 * Optional ��ü ����
		 *  1. Optional.empty() : �� Optional ��ü �����Ѵ�
		 *     ��) Optional<String> optStr = Optional.empty();
		 *     
		 *  2. Optional.of(value) : value���� null�� �ƴ� ��쿡 ����Ѵ�
		 *     ��1) String str = "test";
		 *          Optional<String> optStr1 = Optional.of(str);
		 *     ��2) String nullStr = null;
		 *          Optional<String> optStr2 = Optional.of(nullStr); //NPE �߻�
		 *          
		 *  3. Optional.ofNullable(value) : value���� null���� �ƴ��� Ȯ������ ���� ��쿡 ����Ѵ�
		 *     ��) String str = "test";
		 *        Optional<String> optStr1 = Optional.ofNullable(str);
		Optional<Users> optUser = Optional.ofNullable(userInfo);
		
		optUser.map(Users :: getUser_id)
			   .filter(s -> s.equals("frank")).isPresent();
//		hashUtil.isMatch(userPwd, s2);
		 */
		
		session.setAttribute("loginUser", userInfo);
		
		return "index";
	}
}
