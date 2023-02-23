package com.study.youtubeteam.emtity;

public class youtubeMyView {
	private int idx;
	private String user_id;
	private String subject;
	private String writer;
	private String readcount;
	private String url;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getReadcount() {
		return readcount;
	}
	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "youtubeMyView [idx=" + idx + ", user_id=" + user_id + ", subject=" + subject + ", writer=" + writer
				+ ", readcount=" + readcount + ", url=" + url + "]";
	}
	
	
}
