package com.stech.meetat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stech.meetat.pojo.EventDetails;
import com.stech.meetat.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController {
	@Autowired
	EventService eventService;
	
	@RequestMapping(value = "/addEvent", method = RequestMethod.POST)
	public @ResponseBody String addEvent(@RequestBody EventDetails eventDetails) {
		return eventService.addEvent(eventDetails);
	}

	@RequestMapping(value = "/getEvents/{locationId}", method = RequestMethod.GET)
	public @ResponseBody List<EventDetails> getEvents(@PathVariable("locationId") int locationId) {
		return eventService.getEvents(locationId);
	}

	@RequestMapping(value = "/getEvent/{eventId}", method = RequestMethod.GET)
	public @ResponseBody EventDetails getEvent(@PathVariable("eventId") int eventId) {
		return eventService.getEvent(eventId);
	}

	@RequestMapping(value = "/updateEvent", method = RequestMethod.POST)
	public @ResponseBody String updateEvent(@RequestBody EventDetails eventDetails) {
		return eventService.updateEvent(eventDetails);
	}

	@RequestMapping(value = "/deleteEvent/{eventId}", method = RequestMethod.GET)
	public @ResponseBody String deleteEvent(@PathVariable int eventId) {
		return eventService.deleteEvent(eventId);
	}
}
