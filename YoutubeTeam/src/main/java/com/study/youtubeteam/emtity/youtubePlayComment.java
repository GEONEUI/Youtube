package com.study.youtubeteam.emtity;


public class youtubePlayComment {

	private int idx;
	private int comment_id;
	private String content;
	private String user_id;
	private String nowdate;
	private String nikname;
	private String user_img;
	
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	@Override
	public String toString() {
		return "youtubePlayComment [idx=" + idx + ", comment_id=" + comment_id + ", content=" + content + ", user_id="
				+ user_id + ", nowdate=" + nowdate + ", nikname=" + nikname + ", user_img=" + user_img + "]";
	}
	
	
	
	
}