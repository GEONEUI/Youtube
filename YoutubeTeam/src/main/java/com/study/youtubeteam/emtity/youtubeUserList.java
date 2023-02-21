package com.study.youtubeteam.emtity;



public class youtubeUserList {
	private String user_idx;
	private String user_id;
	private String user_pw;
	private String user_nikname;
	private String user_email;
	private String user_img;
	public String getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(String user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_nikname() {
		return user_nikname;
	}
	public void setUser_nikname(String user_nikname) {
		this.user_nikname = user_nikname;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Override
	public String toString() {
		return "youtubeUserList [user_idx=" + user_idx + ", user_id=" + user_id + ", user_pw=" + user_pw
				+ ", user_nikname=" + user_nikname + ", user_email=" + user_email + "]";
	}
	
	

	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	

}
