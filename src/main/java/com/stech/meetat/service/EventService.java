package com.stech.meetat.service;

import java.util.List;

import com.stech.meetat.pojo.EventDetails;

public interface EventService {
	  public String addEvent(EventDetails eventDetails);
	  public List<EventDetails> getEvents(int locationId);
	  public EventDetails getEvent(int eventId);
	  public String updateEvent(EventDetails eventDeatils);
	  public String deleteEvent(int eventId);
}
