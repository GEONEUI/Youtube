package com.study.youtubeteam.emtity;


public class youtubeList {
	private int idx;
	private String subject;
	private String writer;
	private int readcount;
	private String thum;
	private String url;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public String getThum() {
		return thum;
	}
	public void setThum(String thum) {
		this.thum = thum;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "youtubeList [idx=" + idx + ", subject=" + subject + ", writer=" + writer + ", readcount=" + readcount
				+ ", thum=" + thum + ", url=" + url + "]";
	}
	
	
	
	
}
