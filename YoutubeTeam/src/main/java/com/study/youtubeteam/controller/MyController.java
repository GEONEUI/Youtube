package com.study.youtubeteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	//건의
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	//예준
	@RequestMapping("/play")
	public String play() {
		return "play";
	}
	
	//준호
	@RequestMapping("/channel")
	public String channel() {
		return "channel";
	}
	
	//준호
	@RequestMapping("/channelBoard")
	public String channelBoard() {
		return "channelBoard";
	}
	
	//준호
	@RequestMapping("/channelIndex")
	public String channelIndex() {
		return "channelIndex";
	}
	
	//유진
	@RequestMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
}
