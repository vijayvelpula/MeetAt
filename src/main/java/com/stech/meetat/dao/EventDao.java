package com.stech.meetat.dao;

import java.util.List;

import com.stech.meetat.pojo.EventDetails;

public interface EventDao {
	public String addEvent(EventDetails eventDetails);
	public List<EventDetails> getEvents(int locationId);
	public EventDetails getEvent(int eventId);
	public String updateEvent(EventDetails eventDetails);
	public String deleteEvent(int eventId);
	public List<EventDetails> getEvents(int locationId, int roomId);
}
