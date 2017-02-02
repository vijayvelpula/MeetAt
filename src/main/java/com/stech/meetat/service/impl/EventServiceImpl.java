package com.stech.meetat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stech.meetat.dao.EventDao;
import com.stech.meetat.pojo.EventDetails;
import com.stech.meetat.service.EventService;
@Service("eventService")
public class EventServiceImpl implements EventService {

	@Autowired
	EventDao eventDao;
	
	public String addEvent(EventDetails eventDetails) {
		return eventDao.addEvent(eventDetails);
	}

	public List<EventDetails> getEvents(int locationId) {
		return eventDao.getEvents(locationId);
	}

	public EventDetails getEvent(int eventId) {
		return eventDao.getEvent(eventId);
	}

	public String updateEvent(EventDetails eventDetails) {
		return eventDao.updateEvent(eventDetails);
	}

	public String deleteEvent(int eventId) {
		return eventDao.deleteEvent(eventId);
	}

}
