package com.study.youtubeteam.emtity;

public class youtubeMyComment {

	private int idx;
	private String user_id;
	private String content;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "youtubeMyComment [idx=" + idx + ", user_id=" + user_id + ", content=" + content + "]";
	}
	
	
}
