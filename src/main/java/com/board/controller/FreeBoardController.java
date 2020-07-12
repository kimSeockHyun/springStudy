package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.service.freeBoard.FreeBoardListService;

@Controller
public class FreeBoardController {
	
	@Autowired
	private FreeBoardListService freeBoardListService;
	
	private int returnIntValue(String stringToInt) {
		
		return Integer.parseInt(stringToInt);
	}
	
	@GetMapping(value = "/freeBoard")
	public String freeBoard(@RequestParam(value="pageNum", defaultValue="1")String pageNum) throws Exception{
		String rtnPage = freeBoardListService.freeBoardList(returnIntValue(pageNum));
		return rtnPage;
	}
	
}
