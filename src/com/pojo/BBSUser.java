package com.pojo;

import java.util.Date;

public class BBSUser {
	private String userId; 		//账户名
	private String userPsw;		//密码
	private String userAlice;	//昵称
	private String userEmail;	//邮箱
	private String userSex;		//性别	
	private String userPhoto;	//头像
	private Double userScore;	//积分
	private Integer userLevel;	//等级
	private Date levelDown;		//降级日期
	private Date userLock;		//锁定日期
	private Date userCreateDate;	//创建日期
	public BBSUser() {}
	public BBSUser(String userId, String userPsw, String userAlice, String userEmail, String userSex, String userPhoto,
			Double userScore, Integer userLevel, Date levelDown, Date userLock, Date userCreateDate) {
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
	
}
