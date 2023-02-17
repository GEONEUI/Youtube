package com.study.youtubeteam.emtity;


public class youtubePlayComment {

	private int idx;
	private int comment_id;
	private String content;
	private String writer;
	
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
	
	@Override
	public String toString() {
		return "youtubePlayComment [idx=" + idx + ", comment_id=" + comment_id + ", content=" + content + ", writer="
				+ writer + "]";
	}
	
	
	
}