package com.study.youtubeteam.emtity;


public class youtubePlayComment {

	private int idx;
	private int comment_id;
	private String content;
	private String writer;
	private String nowdate;
	private String nikname;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getNowdate() {
		return nowdate;
	}
	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}
	public String getNikname() {
		return nikname;
	}
	public void setNikname(String nikname) {
		this.nikname = nikname;
	}
	
	@Override
	public String toString() {
		return "youtubePlayComment [idx=" + idx + ", comment_id=" + comment_id + ", content=" + content + ", writer="
				+ writer + ", nowdate=" + nowdate + ", nikname=" + nikname + "]";
	}
	
	
	
	
	
}