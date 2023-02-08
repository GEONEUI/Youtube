package com.study.youtubeteam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.study.youtubeteam.emtity.youtubeList;

@Mapper
public interface YoutubeListMapper {
	
	@Select("SELECT * FROM youtubeList ORDER BY RAND()")
	List<youtubeList> selectAll();
}
