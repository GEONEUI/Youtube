package com.study.youtubeteam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.youtubeteam.emtity.Chat;
import com.study.youtubeteam.emtity.youtubeList;
import com.study.youtubeteam.emtity.youtubeUserList;

@Mapper
public interface YoutubeListMapper {
	
	//랜덤으로 동영상 추출
	@Select("SELECT * FROM youtubeList ORDER BY RAND()")
	List<youtubeList> selectAll();
	
	//랜덤으로 동영상 추출
	@Select("SELECT * FROM youtubeList where category = ${param1} ORDER BY RAND()")
	List<youtubeList> selectCate(int category);
	
	//회원가입
	@Insert("insert into youtubeUser values(null, #{user_id}, #{user_pw}, #{user_nikname}, #{user_email}, #{user_img})")
	public void userInsert(youtubeUserList vo);
	
	//로그인
	@Select("select count(*) from youtubeUser where user_id = #{id} and user_pw = #{pw}")
	public int userCheck(@Param("id") String id, @Param("pw") String pw);
	
	//검색기능
	@Select("SELECT * FROM youtubeList WHERE subject LIKE '%${param1}%'")
	public List<youtubeList> dataSearch(String search);
	
	//아이디 중복체크
	@Select("SELECT COUNT(*) FROM youtubeUser WHERE user_id = #{user_id}")
	public int searchId(String user_id);
	
	//아이디를 알고있을때 정보를 가져오기
	@Select("select * from youtubeUser where user_id = #{id}")
	public youtubeUserList getOneUser(String id);
	
	//댓글작성
	@Insert("insert into chat(chat_id, chat_img, chat_area) values(#{chat_id}, #{chat_img}, #{chat_area})")
	public void chatInsert(Chat vo);
	
	//댓글내용 가져오기
	@Select("select * from chat")
	public List<Chat> selectChat();
	
	//프로필사진 변경
	@Update("update youtubeUser set user_img = #{user_img} where user_id = #{user_id}")
	public void profileUpdate(@Param("user_img") String user_img, @Param("user_id") String user_id);
	
}
	
