package com.study.youtubeteam.emtity;

import java.sql.Date;

public class youtubeMyComment {

	
	private String user_id;
	private String content;
	private Date nowdate;
	private String subject;
	private String writer;
	private int readcount;
	private String url;
	private String thum;
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
	public Date getNowdate() {
		return nowdate;
	}
	public void setNowdate(Date nowdate) {
		this.nowdate = nowdate;
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
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThum() {
		return thum;
	}
	public void setThum(String thum) {
		this.thum = thum;
	}
	public youtubeMyComment(String user_id, String content, Date nowdate, String subject, String writer, int readcount,
			String url, String thum) {
		super();
		this.user_id = user_id;
		this.content = content;
		this.nowdate = nowdate;
		this.subject = subject;
		this.writer = writer;
		this.readcount = readcount;
		this.url = url;
		this.thum = thum;
	}
	
	

	
}
