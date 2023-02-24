package com.study.youtubeteam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.youtubeteam.emtity.youtubeChannel;
import com.study.youtubeteam.emtity.youtubeMyComment;
import com.study.youtubeteam.emtity.youtubeMyView;
import com.study.youtubeteam.emtity.youtubePlayComment;
import com.study.youtubeteam.emtity.youtubeUserList;

@Mapper
public interface YoutubeUpdateMapper {
	// 정보 수정
	@Update("UPDATE youtubeUser SET user_pw = #{user_pw}, user_nikname = #{user_nikname}, user_email = #{user_email} WHERE user_id = #{user_id}")
	public void profile_updateProc(youtubeUserList vo);

	@Insert("insert into youtubeMyView values(#{idx}, #{id})")
	public void insertView(@Param("idx") int idx, @Param("id") String id);

	// 시청기록
	@Select("SELECT DISTINCT(a1.idx), a1.user_id, a2.subject, a2.writer, a2.readcount, a2.url FROM youtubeMyView a1, youtubeList a2 WHERE a1.idx = a2.idx AND a1.user_id = #{id}")
	public List<youtubeMyView> selectMyView(String id);

	// 시청기록 하나 삭제
	@Delete("delete from youtubeMyView where user_id=#{param1} and idx=#{param2}")
	public void delete(String user_id, int idx);

	// 시청기록 전체 삭제
	@Delete("delete from youtubeMyView where user_id=#{user_id}")
	public void deleteAll(String user_id);

	// 내가 쓴 댓글
	@Select("SELECT a1.user_id, a1.content, a1.nowdate, a2.subject, a2.writer, a2.readcount, a2.url, a2.thum FROM youtubePlayComment a1, youtubeList a2 WHERE a1.user_id = #{id} AND a1.idx=a2.idx")
	public List<youtubeMyComment> selectMyComment(String id);

}
