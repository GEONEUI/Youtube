package com.study.youtubeteam.emtity;

public class youtubeFollowList {
	private int user_idx;
	private int idx;
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	@Override
	public String toString() {
		return "youtubeFollow [user_idx=" + user_idx + ", idx=" + idx + "]";
	}
	
	
}
