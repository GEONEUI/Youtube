package com.study.youtubeteam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.study.youtubeteam.emtity.youtubeChannel;

@Mapper
public interface YoutubeFollowMapper {
	
	@Insert("insert into followList values(#{user_idx}, #{follow}")
	public void followInsert(int loginUser, int followUser);
	
	@Select("select user_idx from followList where user_idx=#{user_idx}")
	public int followCheck(int loginUser);
	
	@Select("select user_idx from youtubeUser where user_id=#{user_id}")
	public int getId(String loginUser);
	
	//채널 정보
	@Select("select * from channelList where idx=#{idx}")
	public List<youtubeChannel> channelIdx(int idx);
}
