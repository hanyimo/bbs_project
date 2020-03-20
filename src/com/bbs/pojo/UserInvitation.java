package com.bbs.pojo;

import java.util.Date;

public class UserInvitation {
	private String invitationId;
	private String userAlice;
	private String userPhoto;
	private String invitationTitle;
	private String invitationMessage;
	private Date invitationCreate;
	public UserInvitation() {
		super();
	}
	public UserInvitation(String invitationId, String userAlice, String userPhoto, String invitationTitle,
			String invitationMessage, Date invitationCreate) {
		super();
		this.invitationId = invitationId;
		this.userAlice = userAlice;
		this.userPhoto = userPhoto;
		this.invitationTitle = invitationTitle;
		this.invitationMessage = invitationMessage;
		this.invitationCreate = invitationCreate;
	}
	public Date getInvitationCreate() {
		return invitationCreate;
	}
	public void setInvitationCreate(Date invitationCreate) {
		this.invitationCreate = invitationCreate;
	}
	public String getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public String getUserAlice() {
		return userAlice;
	}
	public void setUserAlice(String userAlice) {
		this.userAlice = userAlice;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getInvitationTitle() {
		return invitationTitle;
	}
	public void setInvitationTitle(String invitationTitle) {
		this.invitationTitle = invitationTitle;
	}
	public String getInvitationMessage() {
		return invitationMessage;
	}
	public void setInvitationMessage(String invitationMessage) {
		this.invitationMessage = invitationMessage;
	}
}
