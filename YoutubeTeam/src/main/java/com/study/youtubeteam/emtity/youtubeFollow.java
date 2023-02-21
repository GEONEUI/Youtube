package com.study.youtubeteam.emtity;

public class youtubeFollow {
	private int user_idx;
	private int follow;
	private int idx;
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public int getFollow() {
		return follow;
	}
	public void setFollow(int follow) {
		this.follow = follow;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	@Override
	public String toString() {
		return "youtubeFollow [user_idx=" + user_idx + ", follow=" + follow + ", idx=" + idx + "]";
	}
	
	
}
