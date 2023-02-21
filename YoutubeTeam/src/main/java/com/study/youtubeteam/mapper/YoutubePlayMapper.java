package com.study.youtubeteam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.study.youtubeteam.emtity.youtubeList;
import com.study.youtubeteam.emtity.youtubePlayComment;

@Mapper
public interface YoutubePlayMapper {

	@Select("select * from youtubeList where idx = #{a}")
	public youtubeList getOne(@Param("a") int a);
	
	@Insert("insert into youtubePlayComment(idx, content, nikname, user_id) values (#{idx}, #{content}, #{nikname}, #{user_id})")
	public void write(youtubePlayComment pc);
	
	@Select("select * from youtubePlayComment where idx = #{idx}")
	public List<youtubePlayComment> selectOne(int idx);
	
	@Select("select count(*) from youtubePlayComment where idx = #{idx}")
	public int view(int idx);
	
//	@Select("SELECT a2.idx"
//			+ "FROM youtubeList a1, channelList a2"
//			+ "WHERE a1.writer = a2.writer AND a1.idx = #{a1.idx}")
//	public int chView(int idx);	
}
