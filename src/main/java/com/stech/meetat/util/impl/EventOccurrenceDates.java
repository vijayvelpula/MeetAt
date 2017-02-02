package com.stech.meetat.util.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.stech.meetat.core.CustomDateFormatter;
import com.stech.meetat.core.ReccurrenceType;
import com.stech.meetat.pojo.EventDetails;

public class EventOccurrenceDates {
	
	private static Calendar calendar = Calendar.getInstance();
	private static CustomDateFormatter dateFormatter = new CustomDateFormatter();
	EventDetails event;
	Date inputDate;

	public EventOccurrenceDates(EventDetails event, Date inputDate) {
		this.event = event;
		
		this.inputDate = inputDate;		
	}
	
	public List<String> getDates() {
		String type = event.getRecurrenceType();
		ReccurrenceType abc = ReccurrenceType.valueOf(type);
		switch(abc){
		case DAILY: return calculateForDaily();
		case WEEKLY: return calculateForWeekly();
		case MONTHLY: return calculateForMonthly();
		case MONTHLYWEEKWISE: return calculateForMonthlyWeekWise();
		case YEARLY: return calculateForYearly();
		case CUSTOM: return calulateForCustom();
		default:
			return new ArrayList<String>();
		}
	}

	private List<String> calculateForDaily() {
		List<String> listDates = null;
		Date lastOccrDate = event.getLastOccurrence();
		calendar.setTime(lastOccrDate);
		System.out.println("lastOccrDate: "+lastOccrDate);
		System.out.println("inputDate: "+inputDate);
		if(inputDate != null){
			listDates = new ArrayList<String>();
			while(calendar.getTime().before(inputDate) || calendar.getTime().equals(inputDate)){
				listDates.add(dateFormatter.formatToString(calendar.getTime()));
				calendar.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
		return listDates;
	}

	private List<String> calculateForWeekly() {
		List<String> listDates = null;
		Date lastOccrDate = event.getLastOccurrence();
		calendar.setTime(lastOccrDate);
		if(inputDate != null){
			listDates = new ArrayList<String>();
			while(calendar.getTime().before(inputDate) || calendar.getTime().equals(inputDate)){
				listDates.add(dateFormatter.formatToString(calendar.getTime()));
				calendar.add(Calendar.DAY_OF_MONTH, 7);
			}
		}
		return listDates;
	}

	private List<String> calculateForMonthly() {
		List<String> listDates = null;
		Date lastOccrDate = event.getLastOccurrence();
		calendar.setTime(lastOccrDate);
		System.out.println("lastOccrDate: "+lastOccrDate);
		System.out.println("inputDate: "+inputDate);
		if(inputDate != null){
			listDates = new ArrayList<String>();
			while(calendar.getTime().before(inputDate) || calendar.getTime().equals(inputDate)){
				listDates.add(dateFormatter.formatToString(calendar.getTime()));
				calendar.add(Calendar.MONTH, 1);
			}
		}
		return listDates;
	}

	private List<String> calculateForMonthlyWeekWise() {
		List<String> listDates = null;
		Date lastOccrDate = event.getLastOccurrence();
		calendar.setTime(lastOccrDate);
		if(inputDate != null){
			listDates = new ArrayList<String>();
			while(calendar.getTime().before(inputDate) || calendar.getTime().equals(inputDate)){
				listDates.add(dateFormatter.formatToString(calendar.getTime()));
				calendar.add(Calendar.MONTH, 1);
			}
		}
		return listDates;
	}
	
	private List<String> calculateForYearly() {
		List<String> listDates = null;
		Date lastOccrDate = event.getLastOccurrence();
		calendar.setTime(lastOccrDate);
		if(inputDate != null){
			listDates = new ArrayList<String>();
			while(calendar.getTime().before(inputDate) || calendar.getTime().equals(inputDate)){
				listDates.add(dateFormatter.formatToString(calendar.getTime()));
				calendar.add(Calendar.YEAR, 1);
			}
		}
		return listDates;
	}
	
	
	private List<String> calulateForCustom() {
		return null;
	}
}
