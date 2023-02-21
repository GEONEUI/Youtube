package com.study.youtubeteam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.study.youtubeteam.emtity.youtubeChannel;
import com.study.youtubeteam.emtity.youtubeList;

@Mapper
public interface YoutubeFollowMapper {
	
	@Insert("insert into followList values(#{param1}, #{param2})")
	public void followInsert(int loginUser, int idx);
	
	@Delete("delete from followList where user_idx=#{param1} and idx=#{param2}")
	public void followDelete(int loginUser, int idx);
	
	@Select("select user_idx from followList where user_idx=#{param1} and idx=#{param2}")
	public Integer followCheck(int loginUser, int idx);
	
	@Select("select user_idx from youtubeUser where user_id=#{user_id}")
	public int getId(String loginUser);
	
	//채널 정보
	@Select("select * from channelList where idx=#{idx}")
	public List<youtubeChannel> channelIdx(int idx);
	
	//동영상 정보
	@Select("select writer from channelList where idx=#{idx}")
	public String getWriter(int idx);
	
	@Select("SELECT * FROM youtubeList WHERE writer = #{writer}")
	public List<youtubeList> selectVideo(String writer);
	
	//검색 기능
	@Select("SELECT * FROM youtubeList WHERE subject LIKE '%${param1}%' and writer like '%${param2}%'")
	public List<youtubeList> vdSearch(String search, String writer);
}
