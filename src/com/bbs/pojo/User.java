package com.bbs.pojo;

import java.util.Date;

public class User {
	private String userId;
	private String userPsw;
	private String userAlice;
	private String userEmail;
	private String userSex;
	private String userPhoto;
	private Double userScore;
	private Integer userLevel;
	private Date levelDown;
	private Date userLock;
	private Date userCreateDate;
	private Integer isPass;
	public User() {}
	public User(String userId, String userPsw, String userAlice, String userEmail, String userSex, String userPhoto,
			Double userScore, Integer userLevel, Date levelDown, Date userLock, Date userCreateDate, Integer isPass) {
		super();
		this.userId = userId;
		this.userPsw = userPsw;
		this.userAlice = userAlice;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.userPhoto = userPhoto;
		this.userScore = userScore;
		this.userLevel = userLevel;
		this.levelDown = levelDown;
		this.userLock = userLock;
		this.userCreateDate = userCreateDate;
		this.isPass = isPass;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPsw=" + userPsw + ", userAlice=" + userAlice + ", userEmail="
				+ userEmail + ", userSex=" + userSex + ", userPhoto=" + userPhoto + ", userScore=" + userScore
				+ ", userLevel=" + userLevel + ", levelDown=" + levelDown + ", userLock=" + userLock
				+ ", userCreateDate=" + userCreateDate + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPsw() {
		return userPsw;
	}
	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}
	public String getUserAlice() {
		return userAlice;
	}
	public void setUserAlice(String userAlice) {
		this.userAlice = userAlice;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public Double getUserScore() {
		return userScore;
	}
	public void setUserScore(Double userScore) {
		this.userScore = userScore;
	}
	public Integer getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	public Date getLevelDown() {
		return levelDown;
	}
	public void setLevelDown(Date levelDown) {
		this.levelDown = levelDown;
	}
	public Date getUserLock() {
		return userLock;
	}
	public void setUserLock(Date userLock) {
		this.userLock = userLock;
	}
	public Date getUserCreateDate() {
		return userCreateDate;
	}
	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}
	public Integer getIsPass() {
		return isPass;
	}
	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}
}










