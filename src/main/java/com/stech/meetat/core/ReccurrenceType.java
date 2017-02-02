package com.stech.meetat.core;

public enum ReccurrenceType {
	DAILY("Daily"),WEEKLY("Weekly"),MONTHLY("Monthly"),MONTHLYWEEKWISE("MonthlyWeekWise"),YEARLY("Yearly"),CUSTOM("Custom");
	
	private String value;
	
	ReccurrenceType(String value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	
}
