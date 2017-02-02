package com.stech.meetat.util.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.util.Assert;

import com.stech.meetat.pojo.EventDetails;
import com.stech.meetat.util.impl.EventOccurrenceDates;

public class EventOccurrenceDatesImplTest {
	private static Calendar calendar = Calendar.getInstance();
	private static EventOccurrenceDates eventOccurrenceDates = new EventOccurrenceDates(getEvent(), calendar.getTime());
	
	@Test
	public void testCalculateForDaily(){
		/*List<String> result = eventOccurrenceDates.getDates();
		System.out.println("Daily: "+result);
		Assert.notNull(result);*/
	}

	@Test
	public void testCalculateForWeekly(){
		List<String> result = eventOccurrenceDates.getDates();
		System.out.println("Weekly: "+result);
		Assert.notNull(result);
	}
	
	@Test
	public void testCalculateForMonthly(){
		EventDetails event = getEvent();
		event.setRecurrenceType("Monthly");
		eventOccurrenceDates = new EventOccurrenceDates(event, calendar.getTime());
		List<String> result = eventOccurrenceDates.getDates();
		System.out.println("Monthly: "+result);
		Assert.notNull(result);
	}
	
	@Test
	public void testCalculateForYearly(){
		EventDetails event = getEvent();
		event.setRecurrenceType("Yearly");
		eventOccurrenceDates = new EventOccurrenceDates(event, calendar.getTime());
		List<String> result = eventOccurrenceDates.getDates();
		System.out.println("Yearly: "+result);
		Assert.notNull(result);
	}
	
	private static EventDetails getEvent(){
		EventDetails event = new EventDetails();
		Date startDate = new Date();
		calendar.setTime(startDate);
		calendar.add(Calendar.MONTH, 3);
		Date endDate = calendar.getTime();
		Date lastOccurrence = startDate;
		
		event.setStartDate(startDate);
		event.setEndDate(endDate);
		event.setLastOccurrence(lastOccurrence);
		return event;
	}
}
