package com.study.youtubeteam.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.youtubeteam.emtity.Chat;
import com.study.youtubeteam.emtity.youtubeChannelList;
import com.study.youtubeteam.emtity.youtubeChannelIndex;
import com.study.youtubeteam.emtity.youtubeList;
import com.study.youtubeteam.emtity.youtubeMyComment;
import com.study.youtubeteam.emtity.youtubeMyView;
import com.study.youtubeteam.emtity.youtubePlayComment;
import com.study.youtubeteam.emtity.youtubeUserList;
import com.study.youtubeteam.mapper.YoutubeFollowMapper;
import com.study.youtubeteam.mapper.YoutubeListMapper;
import com.study.youtubeteam.mapper.YoutubePlayMapper;
import com.study.youtubeteam.mapper.YoutubeUpdateMapper;


@Controller
public class MyController {
	@Autowired
	YoutubeListMapper mapper;
	@Autowired
	YoutubePlayMapper playMapper;
	@Autowired
	YoutubeFollowMapper flmapper;
	@Autowired
	YoutubeUpdateMapper profileMapper;

	// ************************* 건의 *************************

	// 유투브 전체 리스트 불러오기

	// 건의
	@RequestMapping("/")
	public String index(@RequestParam(value = "category", required = false, defaultValue = "1") int category,
			@RequestParam(value = "search", required = false, defaultValue = "") String search, Model model,
			HttpSession session) {
		String id = (String) session.getAttribute("id");

		// 아이디를 알고있을때 해당 아이디의

		if (id == null) {
			id = "손님";
		}

		List<youtubeList> list = null;

		youtubeUserList userInfo = mapper.getOneUser(id);

		if (category == 1) {
			list = mapper.selectAll();
		}
		if (category == 2) {
			list = mapper.selectCate(category);
		}
		if (category == 3) {
			list = mapper.selectCate(category);
		}
		if (category == 4) {
			list = mapper.selectCate(category);
		}
		if (category == 5) {
			list = mapper.selectCate(category);
		}
		if (category == 6) {
			list = mapper.selectCate(category);
		}
		if (category == 7) {
			list = mapper.selectCate(category);
		}
		if (category == 8) {
			list = mapper.selectAll();
		}

		if (search.equals("")) {

		} else {
			list = mapper.dataSearch(search);
		}

		model.addAttribute("list", list);
		model.addAttribute("id", id);
		model.addAttribute("search", search);
		model.addAttribute("category", category);
		model.addAttribute("userInfo", userInfo);

		return "index";
	}
	// -------------------------------------------------------

	// 회원가입
	@RequestMapping("/join.do")
	public String join() {

		return "join";
	}

	// 회원가입 데이터 받는곳
	@PostMapping("/joinProc.do")
	public String joinProc(youtubeUserList vo) {
		vo.setUser_img("./image/default.jpg");
		mapper.userInsert(vo);
		return "redirect:/joinMessage.do";
	}

	// 회원가입 성공후 메세지화면
	@RequestMapping("/joinMessage.do")
	public String joinMessage() {
		return "joinMessage";
	}

	// 로그인
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, Model model) {

		Cookie[] cookies = request.getCookies();

		String CookieID = "";
		String CookiePW = "";

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cookieID")) {
					CookieID = cookies[i].getValue();
					break;
				}
			}
		}

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cookiePW")) {
					CookiePW = cookies[i].getValue();
					break;
				}
			}
		}

		model.addAttribute("CookieID", CookieID);
		model.addAttribute("CookiePW", CookiePW);

		return "login";
	}

	// 로그인 처리하는곳
	@PostMapping("/loginProc.do")
	public String loginProc(@RequestParam("user_id") String id, @RequestParam("user_pw") String pw,
			@RequestParam(value = "checkbox", required = false, defaultValue = "0") int check, Model model,
			HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		int result = mapper.userCheck(id, pw);
		
		if(result == 1) { //로그인 성공
			// 세션생성
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(60 * 10);
			model.addAttribute("result", result);
			
			// 쿠키생성
			if (check == 1) {
				Cookie cookie = new Cookie("cookieID", id);
				cookie.setMaxAge(60 * 1);
				response.addCookie(cookie);

				Cookie cookiepw = new Cookie("cookiePW", pw);
				cookiepw.setMaxAge(60 * 1);
				response.addCookie(cookiepw);
			}
			
			return "redirect:/";
		} else {
			return "loginMessage";
		}
		

	}

	// 로그아웃 처리하는곳
	@RequestMapping("/logoutProc.do")
	public String logoutProc(HttpSession session) {
		session.setAttribute("id", null);
		session.setMaxInactiveInterval(0);

		
		return "redirect:/";
	}

	// 로그인 중복체크
	@RequestMapping("/loginCheck.do")
	public @ResponseBody int loginCheck(@RequestParam("user_id") String userid, Model model) {
		int result = mapper.searchId(userid);
		return result;
	}
	
	//채팅입력
	@GetMapping("/chatInsert.do")
	public @ResponseBody void chatInsert(Chat vo) {
		mapper.chatInsert(vo);
	}
	
	@GetMapping("/chat.do")
	public @ResponseBody List<Chat> chat(){
		List<Chat> clist = mapper.selectChat();
		
		return clist;
	}
	
	//프로필 사진변경
	@RequestMapping("/profileChange.do")
	public String profileChange(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");

		if (id == null) {
			id = "손님";
		}
		youtubeUserList userInfo = mapper.getOneUser(id);
		model.addAttribute("userInfo", userInfo);
		
		return "/profileChange";
	}
	
	@RequestMapping("/profileChangeProc.do")
	public String upload(@RequestPart MultipartFile file, HttpServletRequest request) throws Exception {
			String originalfileName = file.getOriginalFilename();
			String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/upload";
			String user_id = request.getParameter("user_id");
			String random = ""+Math.random();
			
			String lastName = projectPath + "/"+ random + originalfileName;
			String imgPath = "./upload/";
			String realName = imgPath + random + originalfileName;
			
			File dest = new File(lastName);
			System.out.println(dest);
			file.transferTo(dest);
			
			
			mapper.profileUpdate(realName, user_id);
			
			

		return "redirect:/mypage";
	}
	
	
	

	// 예준-재생 메인 페이지
	   @RequestMapping("/play")
	   public String play(@RequestParam(value = "idx", required = false, defaultValue = "1") int idx, String sub,
	         HttpSession session, Model model) {

	      String id = (String) session.getAttribute("id");
	      if (id == null) {
	         id = "손님";
	      }

	      String url = "/channel?idx=";
	      youtubeList list = playMapper.getOne(idx);
	      youtubeUserList userInfo = mapper.getOneUser(id);
	      List<youtubeList> elst = mapper.selectAll();
	      playMapper.getCount(idx);
	      List<youtubePlayComment> pp = playMapper.selectOne(idx);
	      
	      //유진 기록
	      profileMapper.insertView(idx, id);
	      
	      int rr = playMapper.view(idx);
	      int ss = playMapper.chView(idx);
	      String rjsdml = url + ss;
	      String subs = playMapper.subscribe(ss);
	      
	      model.addAttribute("userInfo", userInfo);
	      model.addAttribute("id", id);
	      model.addAttribute("list", list);
	      model.addAttribute("elst", elst);
	      model.addAttribute("pp", pp);
	      model.addAttribute("rr", rr);
	      model.addAttribute("ss", rjsdml);
	      model.addAttribute("subs", subs);
	      return "play";

	   }

	// 예준-댓글 작성 메소드로 이동
	@GetMapping("/write")
	public String write(youtubePlayComment pc) {
		playMapper.write(pc);
		return "redirect:/play?idx=" + pc.getIdx();
	}
	
	// 준호
	//채널 메인
	@RequestMapping("/channel")
	public String channel(@RequestParam(value="search",required=false,defaultValue="") String search, int idx, Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		//아이디를 알고있을때 해당 아이디의
		
				if(id == null) {
					id = "손님";
				}
				
		youtubeUserList userInfo = mapper.getOneUser(id);
		List<youtubeChannelList> list = flmapper.channelIdx(idx);
		String writer = flmapper.getWriter(idx);
		
		List<youtubeList> list2 = flmapper.selectVideo(writer);
		int idNum = flmapper.getId(id);
		Integer flcheck = flmapper.followCheck(idNum, idx);
		
		//검색 부분
		if(search.equals("")) {
			 
		}else {
			list2 = flmapper.vdSearch(search, writer);
		}
		
		model.addAttribute("writer", writer);
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

		List<youtubeChannelList> list = flmapper.channelIdx(idx);
		int idNum = flmapper.getId(id);
		Integer flcheck = flmapper.followCheck(idNum, idx);
		model.addAttribute("id", id);
		model.addAttribute("list", list);
		model.addAttribute("idx", idx);
		model.addAttribute("flcheck", flcheck);
		return "channel";
	}

	// 채널 정보
	@RequestMapping("/channelIndex")
	public String channelIndex(int idx, Model model, HttpSession session) {
		
		//아이디를 알고있을때 해당 아이디의
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			id = "손님";
		}
		
		List<youtubeChannelIndex> idxInfo = flmapper.indexList(idx);
		youtubeUserList userInfo = mapper.getOneUser(id);
		model.addAttribute("userInfo", userInfo);

		List<youtubeChannelList> list = flmapper.channelIdx(idx);
		int idNum = flmapper.getId(id);
		Integer flcheck = flmapper.followCheck(idNum, idx);

		model.addAttribute("id", id);
		model.addAttribute("list", list);
		model.addAttribute("idx", idx);
		model.addAttribute("flcheck", flcheck);
		model.addAttribute("idxInfo", idxInfo);
		return "channelIndex";
	}

	//팔로우 기능
	@GetMapping("/following.do")
	public @ResponseBody void following(int idx, String id){
		int idNum = flmapper.getId(id);
		flmapper.followInsert(idNum, idx);
	}
	
	//팔로우 기능
	@GetMapping("/deleteflw.do")
	public @ResponseBody void deleteflw(int idx, String id){
		int idNum = flmapper.getId(id);
		flmapper.followDelete(idNum, idx);
	}
	
	//일반 동영상 뷰 정렬
	@GetMapping("/vdnomal.do")
	public @ResponseBody List<youtubeList> vdnomal(String writer){
		List<youtubeList> list2 = flmapper.selectVideo(writer);
		return list2;
	}
	
	//채널 동영상 최다뷰 정렬
	@GetMapping("/vdhot.do")
	public @ResponseBody List<youtubeList> vdhot(String writer){
		List<youtubeList> list2 = flmapper.selectHotVideo(writer);
		return list2;
	}
		
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");

		// 아이디를 알고있을때 해당 아이디의

		if (id == null) {
			id = "손님";
		}
		
		youtubeUserList userInfo = mapper.getOneUser(id);
		model.addAttribute("userInfo", userInfo);

		return "mypage";
	}

	// 유진-보관함
	@RequestMapping("/videos")
	public String videos(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");

		if (id == null) {
			id = "손님";
		}
		youtubeUserList userInfo = mapper.getOneUser(id);
		model.addAttribute("id", id);
		model.addAttribute("userInfo", userInfo);
		return "videos";
	}

	// 시청기록
	@RequestMapping("/watchtime")
	public String watchtime(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");

		if (id == null) {
			id = "손님";
		}
		
		youtubeUserList userInfo = mapper.getOneUser(id);
		model.addAttribute("id", id);
		model.addAttribute("userInfo", userInfo);
		List<youtubeMyView> mylist = profileMapper.selectMyView(id);
		model.addAttribute("mylist", mylist);
		
		return "watchtime";
	}
	
	// 시청기록 하나 삭제
	@PostMapping("/delete")
	public String delete(String id, int idx) {
	
	profileMapper.delete(id, idx);
	return "redirect:/watchtime";
	}
	
	// 시청기록 전체 삭제
	@PostMapping("/deleteAll")
	public String delete(String id) {
			
	profileMapper.deleteAll(id);
	return "redirect:/watchtime";
	}

	// 구독
	@RequestMapping("/subscribe")
	public String subscribe(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");

		if (id == null) {
			id = "손님";
		}
		youtubeUserList userInfo = mapper.getOneUser(id);
		model.addAttribute("id", id);
		model.addAttribute("userInfo", userInfo);
		return "subscribe";
	}

	// 내가 쓴 댓글
	@RequestMapping("/comment")
	public String comment(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		
		if (id == null) {
			id = "손님";
		}
		
		youtubeUserList userInfo = mapper.getOneUser(id);
		model.addAttribute("id", id);
		model.addAttribute("userInfo", userInfo);
		System.out.println("yygyfyyfyf 위 ");
		
		
		List<youtubeMyComment> mycomm = profileMapper.selectMyComment(id);
		System.out.println("yygyfyyfyf 아래 ");
		model.addAttribute("mycomm", mycomm);
		System.out.println("yygyfyyfyf"+mycomm);
		
		return "comment";
	}

	// 내정보 수정페이지
	@RequestMapping("/profile_update")
	public String profile_update(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");

		if (id == null) {
			id = "손님";
		}
		youtubeUserList userInfo = mapper.getOneUser(id);
		model.addAttribute("userInfo", userInfo);
		return "profile_update";
	}
	
	@PostMapping("/profile_updateProc.do")
	public String profile_updateProc(youtubeUserList vo, Model model, HttpSession session){
		String id = (String) session.getAttribute("id");
		
		if (id == null) {
			id = "손님";
		}
		youtubeUserList userInfo = mapper.getOneUser(id);
		model.addAttribute("userInfo", userInfo);
		
		profileMapper.profile_updateProc(vo);
		
		return "redirect:/mypage";
	}
	
}
