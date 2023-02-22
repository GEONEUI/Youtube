package com.study.youtubeteam.emtity;

public class youtubeIndex {
	private int idx;
	private String c_info;
	private String c_email;
	private String c_location;
	private String c_link;
	private String c_day;
	private String c_view;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getC_info() {
		return c_info;
	}
	public void setC_info(String c_info) {
		this.c_info = c_info;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	public String getC_location() {
		return c_location;
	}
	public void setC_location(String c_location) {
		this.c_location = c_location;
	}
	public String getC_link() {
		return c_link;
	}
	public void setC_link(String c_link) {
		this.c_link = c_link;
	}
	public String getC_day() {
		return c_day;
	}
	public void setC_day(String c_day) {
		this.c_day = c_day;
	}
	public String getC_view() {
		return c_view;
	}
	public void setC_view(String c_view) {
		this.c_view = c_view;
	}
	
	@Override
	public String toString() {
		return "youtubeIndex [idx=" + idx + ", c_info=" + c_info + ", c_email=" + c_email + ", c_location=" + c_location
				+ ", c_link=" + c_link + ", c_day=" + c_day + ", c_view=" + c_view + "]";
	}
	
}
