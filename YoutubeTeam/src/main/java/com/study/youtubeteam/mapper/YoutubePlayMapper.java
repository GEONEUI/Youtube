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
	
	@Insert("insert into youtubePlayComment(idx, content, nikname) values (#{idx}, #{content}, #{nikname})")
	public void write(youtubePlayComment pc);
	
	@Select("select * from youtubePlayComment where idx = #{idx}")
	public List<youtubePlayComment> selectOne(int idx);
	
	
}
