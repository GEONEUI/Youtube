package com.study.youtubeteam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.study.youtubeteam.emtity.youtubeList;
import com.study.youtubeteam.emtity.youtubeUserList;

@Mapper
public interface YoutubeListMapper {
	
	@Select("SELECT * FROM youtubeList ORDER BY RAND()")
	List<youtubeList> selectAll();
	
	@Select("SELECT * FROM youtubeList where category = ${param1} ORDER BY RAND()")
	List<youtubeList> selectCate(int category);
	
	@Insert("insert into youtubeUser values(null, #{user_id}, #{user_pw}, #{user_nikname}, #{user_email})")
	public void userInsert(youtubeUserList vo);
	
	
	@Select("select count(*) from youtubeUser where user_id = #{id} and user_pw = #{pw}")
	public int userCheck(@Param("id") String id, @Param("pw") String pw);
	
	
	@Select("SELECT * FROM youtubeList WHERE subject LIKE '%${param1}%'")
	public List<youtubeList> dataSearch(String search);
	
	@Select("SELECT COUNT(*) FROM youtubeUser WHERE user_id = #{user_id}")
	public int searchId(String user_id);
	
	

}
