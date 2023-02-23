package com.study.youtubeteam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.youtubeteam.emtity.youtubeList;
import com.study.youtubeteam.emtity.youtubePlayComment;

@Mapper
public interface YoutubePlayMapper {
	
	//조회수 count
	@Update("update youtubeList set readcount = readcount+rand()+1 where idx = #{a}")
	public int getCount(int a);
	
	// 유튜브 목록 가져와 메인 화면에 뿌리기
	@Select("select * from youtubeList where idx = #{idx}")
	public youtubeList getOne(int idx);
	
	// 댓글 입력시 저장되는 목록
	@Insert("insert into youtubePlayComment(idx, content, nikname, user_id, user_img) values (#{idx}, #{content}, #{nikname}, #{user_id}, #{user_img})")
	public void write(youtubePlayComment pc);
	
	// 댓글 보여주는 부분
	@Select("select * from youtubePlayComment where idx = #{idx}")
	public List<youtubePlayComment> selectOne(int idx);
	
	// 게시물의 댓글 입력 수
	@Select("select count(*) from youtubePlayComment where idx = #{idx}")
	public int view(int idx);
	
	// 채널 아이콘 클릭 시 이동
	@Select("SELECT a2.idx FROM youtubeList a1, youtubeChannelList a2 WHERE a1.writer = a2.writer AND a1.idx = #{idx}")
	public int chView(int idx);	
	
	// 구독자 수 표시
	@Select("select ch_follow from youtubeChannelList where idx = #{idx}")
	public String subscribe(int idx);
	
}
