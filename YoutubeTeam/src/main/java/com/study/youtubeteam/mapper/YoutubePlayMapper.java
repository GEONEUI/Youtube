package com.study.youtubeteam.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.study.youtubeteam.emtity.youtubeList;

@Mapper
public interface YoutubePlayMapper {

	@Select("select * from youtubeList where idx = #{a}")
	public youtubeList getOne(@Param("a") int a);
	
	
}
