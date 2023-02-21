package com.study.youtubeteam.controller;

import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.youtubeteam.emtity.youtubeChannel;
import com.study.youtubeteam.emtity.youtubeList;
import com.study.youtubeteam.emtity.youtubePlayComment;
import com.study.youtubeteam.emtity.youtubeUserList;
import com.study.youtubeteam.mapper.YoutubeFollowMapper;
import com.study.youtubeteam.mapper.YoutubeListMapper;
import com.study.youtubeteam.mapper.YoutubePlayMapper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	YoutubeListMapper mapper;
	@Autowired
	YoutubePlayMapper playMapper;
	@Autowired
	YoutubeFollowMapper flmapper;


	//************************* 건의 *************************
	
	//유투브 전체 리스트 불러오기

	// 건의
	@RequestMapping("/")
	public String index(@RequestParam(value="category",required=false,defaultValue="1") int category, @RequestParam(value="search",required=false,defaultValue="") String search, Model model, HttpSession session){
		String id = (String)session.getAttribute("id");
		
		//아이디를 알고있을때 해당 아이디의
		
		if(id == null) {
			id = "손님";
		}
		
		List<youtubeList> list = null;
		
		
		youtubeUserList userInfo = mapper.getOneUser(id);
		

		if(category==1) {
			list = mapper.selectAll();
			System.out.println(list);
		}
		if(category==2) {
			list = mapper.selectCate(category);
		}
		if(category==3) {
			list = mapper.selectCate(category);
		}
		if(category==4) {
			list = mapper.selectCate(category);
		}
		if(category==5) {
			list = mapper.selectCate(category);
		}
		if(category==6) {
			list = mapper.selectCate(category);
		}
		if(category == 7) {
			list = mapper.selectCate(category);
		}
		if(category == 8) {
			list = mapper.selectAll();
		}
			
		
		if(search.equals("")) {
			
		}else {
			list = mapper.dataSearch(search);
		}
		
		
		
		model.addAttribute("list", list);
		model.addAttribute("id", id);
		model.addAttribute("search", search);
		model.addAttribute("category", category);
		model.addAttribute("userInfo", userInfo);
		
		
		return "index";
	}
	//-------------------------------------------------------
	
	//회원가입
	@RequestMapping("/join.do")
	public String join() {
		

		return "join";
	}
	
	//회원가입 데이터 받는곳
	@PostMapping("/joinProc.do")
	public String joinProc(youtubeUserList vo) {
		mapper.userInsert(vo);
		return "redirect:/joinMessage.do";
	}
	
	//회원가입 성공후 메세지화면
	@RequestMapping("/joinMessage.do")
	public String joinMessage() {
		return "joinMessage";
	}
	
	//로그인
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, Model model) {
		
		Cookie[] cookies = request.getCookies();
		
		String CookieID = "";
		String CookiePW = "";
	
		if(cookies != null) {
			for(int i=0; i<cookies.length ;i++) {
				if(cookies[i].getName().equals("cookieID")) {
					CookieID = cookies[i].getValue();
					break;
				}
			}
		}
		
		if(cookies != null) {
			for(int i=0; i<cookies.length ;i++) {
				if(cookies[i].getName().equals("cookiePW")) {
					CookiePW = cookies[i].getValue();
					break;
				}
			}
		}
		
		
		
		System.out.println(CookieID);
		System.out.println(CookiePW);
		
		model.addAttribute("CookieID", CookieID);
		model.addAttribute("CookiePW", CookiePW);
		
		
		
		return "login";
	}
	
	//로그인 처리하는곳
	@PostMapping("/loginProc.do")
	public String loginProc(@RequestParam("user_id") String id, @RequestParam("user_pw") String pw, @RequestParam(value="checkbox", required = false, defaultValue = "0") int check, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		int result = mapper.userCheck(id, pw);
		
		
		//세션생성
		session.setAttribute("id", id);
		session.setMaxInactiveInterval(60*10);
		model.addAttribute("result", result);
		
		//쿠키생성
		if(check == 1) {
			Cookie cookie = new Cookie("cookieID", id);
			cookie.setMaxAge(60*1);
			response.addCookie(cookie);
			
			Cookie cookiepw = new Cookie("cookiePW", pw);
			cookiepw.setMaxAge(60*1);
			response.addCookie(cookiepw);
		}else {
			
		}
		
		return "loginMessage";
	}
	
	//로그아웃 처리하는곳
	@RequestMapping("/logoutProc.do")
	public String logoutProc(HttpSession session) {
		session.setAttribute("id", null);
		session.setMaxInactiveInterval(0);
		
		return "redirect:/";
	}
	//로그인 중복체크
	@RequestMapping("/loginCheck.do")
	public @ResponseBody int loginCheck(@RequestParam("user_id") String userid, Model model) {
		int result = mapper.searchId(userid);
		return result;
	}
	
	

	//예준-재생 메인 페이지
	@RequestMapping("/play")
	public String play(@RequestParam(value="idx",required=false,defaultValue="1") int idx, HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("id");
		if(id == null) {
			id = "손님";
		}
		
		youtubeList list = playMapper.getOne(idx);
		youtubeUserList userInfo = mapper.getOneUser(id);
		List<youtubeList> elst = mapper.selectAll();
		List<youtubePlayComment> pp = playMapper.selectOne(idx);
		int rr = playMapper.view(idx);
//		int ss = playMapper.chView(idx);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("id", id);
		model.addAttribute("list", list);
		model.addAttribute("elst", elst);
		model.addAttribute("pp", pp);
		model.addAttribute("rr", rr);
//		model.addAttribute("ss", ss);
//		System.out.println(ss);
		return "play";
		
	}
	
	//예준-댓글 작성 메소드로 이동
	@GetMapping("/write")
	public String write(youtubePlayComment pc) {
		playMapper.write(pc);
		return "redirect:/play?idx=" + pc.getIdx();
	}

	
	//채널 메인
	@RequestMapping("/channel")
	public String channel(@RequestParam(value="search",required=false,defaultValue="") String search, int idx, Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		//아이디를 알고있을때 해당 아이디의
		
				if(id == null) {
					id = "손님";
				}
				
		youtubeUserList userInfo = mapper.getOneUser(id);
		List<youtubeChannel> list = flmapper.channelIdx(idx);
		String writer2 = flmapper.getWriter(idx);
		System.out.println(writer2);
		
		List<youtubeList> list2 = flmapper.selectVideo(writer2);
		String idNum = flmapper.getId(id);
		String flcheck = flmapper.followCheck(idNum);
		
		if(search.equals("")) {
			 
		}else {
			list2 = flmapper.vdSearch(search, writer2);
		}
		
		model.addAttribute("id", id);
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		model.addAttribute("idx", idx);
		model.addAttribute("flcheck", flcheck);
		model.addAttribute("userInfo", userInfo);
		return "channel";
	}
	
	//채널 커뮤니티
	@RequestMapping("/channelBoard")
	public String channelBoard(int idx, Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		
		//아이디를 알고있을때 해당 아이디의
		
		if(id == null) {
			id = "손님";
		}
		
		youtubeUserList userInfo = mapper.getOneUser(id);
		model.addAttribute("userInfo", userInfo);
		
		List<youtubeChannel> list = flmapper.channelIdx(idx);
		String idNum = flmapper.getId(id);
		String flcheck = flmapper.followCheck(idNum);
		model.addAttribute("id", id);
		model.addAttribute("list", list);
		model.addAttribute("idx", idx);
		model.addAttribute("flcheck", flcheck);
		return "channelBoard";
	}
	
	//채널 정보
	@RequestMapping("/channelIndex")
	public String channelIndex(int idx, Model model, HttpSession session) {
		
		//아이디를 알고있을때 해당 아이디의
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			id = "손님";
		}
		
		youtubeUserList userInfo = mapper.getOneUser(id);
		model.addAttribute("userInfo", userInfo);
		
		

		List<youtubeChannel> list = flmapper.channelIdx(idx);
		String idNum = flmapper.getId(id);
		String flcheck = flmapper.followCheck(idNum);


		model.addAttribute("id", id);
		model.addAttribute("list", list);
		model.addAttribute("idx", idx);
		model.addAttribute("flcheck", flcheck);
		return "channelIndex";
	}

		//구독
		@RequestMapping("/insertflw")
		public String insertflw(String id, String idx) {
			flmapper.followInsert(id,idx);
			return "channel";
		}
		
		//구독 취소
		@RequestMapping("/deleteflw")
		public void deleteflw(String id) {
			flmapper.followDelete(id);
		}
	
	//유진
		@RequestMapping("/mypage")
		public String mypage() {
			return "mypage";
		}

		// 유진-보관함
		@RequestMapping("/videos")
		public String videos() {
			return "videos";
		}

		// 유진-시청기록
		@RequestMapping("/watchtime")
		public String watchtime() {
			return "watchtime";
		}

		// 유진-구독
		@RequestMapping("/subscribe")
		public String subscribe() {
			return "subscribe";
		}

		// 유진-댓글
		@RequestMapping("/comment")
		public String comment() {
			return "comment";
		}
	


}
