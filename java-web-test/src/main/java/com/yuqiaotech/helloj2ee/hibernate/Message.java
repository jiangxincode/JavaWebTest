package com.yuqiaotech.helloj2ee.hibernate;

import java.util.Date;

public class Message {
	private Long id;
	private String title;
	private String text;
	private Date sentTime;
	private String status;
	// private User sender;
	// private User receiver;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getSentTime() {
		return sentTime;
	}

	public void setSentTime(Date sentTime) {
		this.sentTime = sentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	// public User getSender() {
	// return sender;
	// }
	// public void setSender(User sender) {
	// this.sender = sender;
	// }
	// public User getReceiver() {
	// return receiver;
	// }
	// public void setReceiver(User receiver) {
	// this.receiver = receiver;
	// }

}