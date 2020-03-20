package com.bbs.pojo;

import java.util.Date;

public class InvitationAnsUser {
	private String ansId;
	private String ansMessage;
	private String invitationId;
	private String userAlice;
	private Date ansDate;
	private String userPhoto;
	public InvitationAnsUser() {
		super();
	}
	public InvitationAnsUser(String ansId, String ansMessage, String invitationId, String userAlice, Date ansDate,
			String userPhoto) {
		super();
		this.ansId = ansId;
		this.ansMessage = ansMessage;
		this.invitationId = invitationId;
		this.userAlice = userAlice;
		this.ansDate = ansDate;
		this.userPhoto = userPhoto;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getAnsId() {
		return ansId;
	}
	public void setAnsId(String ansId) {
		this.ansId = ansId;
	}
	public String getAnsMessage() {
		return ansMessage;
	}
	public void setAnsMessage(String ansMessage) {
		this.ansMessage = ansMessage;
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
	public Date getAnsDate() {
		return ansDate;
	}
	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}
}
