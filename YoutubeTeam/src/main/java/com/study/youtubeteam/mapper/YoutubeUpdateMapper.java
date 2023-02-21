package com.study.youtubeteam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.youtubeteam.emtity.youtubeMyView;
import com.study.youtubeteam.emtity.youtubeUserList;


@Mapper
public interface YoutubeUpdateMapper {
	@Update("UPDATE youtubeUser SET user_pw = #{user_pw}, user_nikname = #{user_nikname}, user_email = #{user_email} WHERE user_id = #{user_id}")
	void profile_updateProc(youtubeUserList vo);
	
	@Insert("insert into youtubeMyView values(#{idx}, #{id})")
	void insertView(@Param("idx")int idx, @Param("id")String id);
	
	@Select("SELECT a1.idx, a1.user_id, a2.subject, a2.writer, a2.readcount, a2.url FROM youtubeMyView a1, youtubeList a2 WHERE a1.idx = a2.idx AND a1.user_id = #{id}")
	List<youtubeMyView> selectMyView(String id);
	
	
	
}
