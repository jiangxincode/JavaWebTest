package com.shengsiyuan.hibernate;

public class Student extends Person
{
	private String cardId;

	public String getCardId()
	{
		return cardId;
	}

	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	}
}