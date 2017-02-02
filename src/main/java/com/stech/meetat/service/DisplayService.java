package com.stech.meetat.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.stech.meetat.pojo.ScheduleDetails;

public interface DisplayService {
	public List<ScheduleDetails> getTodaysSchedule();
	public List<ScheduleDetails> getScheduleForDate(Date date);
	public Map<Date, List<ScheduleDetails>> getScheduleForDateRange(Date startDate, Date endDate);
	public void getScheduleOfARoom(String roomId);
	public void getConfictDetails(String roomId, Date date, int timeId);
	public void getScheduleOfAnEvent(String eventId);
}
