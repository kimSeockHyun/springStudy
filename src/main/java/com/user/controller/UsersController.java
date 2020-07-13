package com.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.service.LoginService;
import com.user.service.JoinService;

@Controller
public class UsersController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private JoinService joinService;
	
	@PostMapping(value = "/users/joinRequest")
	public String joinRequest(@RequestParam Map<String, String> paramMap) throws Exception{
		
		String userId = paramMap.get("userId");
		String userPw = paramMap.get("userPw");
		String userNm = paramMap.get("userNm");
		
		String rtnPage = joinService.joinUser(userId,userPw,userNm);

		return rtnPage;
	}
	
	@PostMapping(value = "/loginRequest")
	public String loginRequest(@RequestParam Map<String, String> paramMap) {
	
		String userId = paramMap.get("user_id");
		String userPw = paramMap.get("user_pw");
		
		String rtnPage = loginService.login(userId, userPw);
		
		return rtnPage;
	}
	
}
