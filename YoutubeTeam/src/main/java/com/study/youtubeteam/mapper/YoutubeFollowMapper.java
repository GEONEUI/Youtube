package com.study.youtubeteam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.study.youtubeteam.emtity.youtubeChannelList;
import com.study.youtubeteam.emtity.youtubeChannelIndex;
import com.study.youtubeteam.emtity.youtubeList;

@Mapper
public interface YoutubeFollowMapper {
	
	//구독하기
	@Insert("insert into youtubeFollowList values(#{param1}, #{param2})")
	public void followInsert(int loginUser, int idx);
	
	//구독취소
	@Delete("delete from youtubeFollowList where user_idx=#{param1} and idx=#{param2}")
	public void followDelete(int loginUser, int idx);
	
	//구독 확인
	@Select("select user_idx from youtubeFollowList where user_idx=#{param1} and idx=#{param2}")
	public Integer followCheck(int loginUser, int idx);
	
	//String인 아이디값으로 int인 idx값 가져오기
	@Select("select user_idx from youtubeUser where user_id=#{user_id}")
	public int getId(String loginUser);
	
	//채널 정보
	@Select("select * from youtubeChannelList where idx=#{idx}")
	public List<youtubeChannelList> channelIdx(int idx);
	
	//idx값으로 채널 이름 가져오기
	@Select("select writer from youtubeChannelList where idx=#{idx}")
	public String getWriter(int idx);
	
	//동영상 목록 가져오기
	@Select("SELECT * FROM youtubeList WHERE writer = #{writer}")
	public List<youtubeList> selectVideo(String writer);
	
	//동영상 조회순 정렬
	@Select("select * from youtubeList where writer = #{writer} order by readcount desc")
	public List<youtubeList> selectHotVideo(String writer);
	
	//검색 기능
	@Select("SELECT * FROM youtubeList WHERE subject LIKE '%${param1}%' and writer like '%${param2}%'")
	public List<youtubeList> vdSearch(String search, String writer);
	
	//Index 페이지 정보
	@Select("select * from youtubeChannelIndex where idx=#{idx}")
	public List<youtubeChannelIndex> indexList(int idx);
}
