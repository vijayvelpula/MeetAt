package com.stech.meetat.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stech.meetat.core.EventDetailsRowMapper;
import com.stech.meetat.dao.EventDao;
import com.stech.meetat.pojo.EventDetails;

@PropertySource("classpath:application.properties")
@Repository("eventDao")
public class EventDaoImpl implements EventDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	Environment environment;

	public String addEvent(EventDetails eventDetails) {
		int effectedRows = 0;
		Object[] args = {eventDetails.getName(),
				eventDetails.getRecurrenceType(),
				eventDetails.getDescription(),
				eventDetails.getCreatedUserId(),
				eventDetails.getOwner(),
				eventDetails.getAttendees(),
				eventDetails.getRoomId(),
				eventDetails.getLocationId(),
				eventDetails.getStartDate(),
				new Date(),
				eventDetails.getStartTimeId(),
				eventDetails.getEndTimeId(),
				eventDetails.getEndDate(),
				new Date()};
		effectedRows = jdbcTemplate.update(environment.getProperty("event.insert"), args);

		if (effectedRows > 0) {
			return environment.getProperty("event.insert.success");
		} else {
			return environment.getProperty("event.insert.fail");
		}
	}

	public List<EventDetails> getEvents(int locationId) {
		List<EventDetails> result;
		String message = environment.getProperty("event.list.fail");
		Object[] args = { locationId };
		result = jdbcTemplate.query(environment.getProperty("event.list"), args, new EventDetailsRowMapper());
		if (result.size() > 0) {
			message = environment.getProperty("event.list.success");
		}
		return result;
	}

	public List<EventDetails> getEvents(int locationId, int roomId) {
		List<EventDetails> result;
		String message = environment.getProperty("event.list.fail");
		Object[] args = { locationId, roomId };
		result = jdbcTemplate.query(environment.getProperty("event.room.list"), args, new EventDetailsRowMapper());
		if (result.size() > 0) {
			message = environment.getProperty("event.list.success");
		}
		return result;
	}

	public EventDetails getEvent(int eventId) {
		List<EventDetails> result;
		String message = environment.getProperty("event.fetch.fail");
		Object[] args = { eventId };
		result = jdbcTemplate.query(environment.getProperty("event.fetch"),	args, new EventDetailsRowMapper());
		if (result.size() > 0 && result.size() == 1) {
			message = environment.getProperty("event.fetch.success");
		} else if (result.size() > 1) {
			message = environment.getProperty("event.fetch.duplicate");
		}
		return result.get(0);
	}

	public String updateEvent(EventDetails eventDetails) {
		int effectedRows = 0;
		Object[] args = { eventDetails.getId() };
		effectedRows = jdbcTemplate.update(environment.getProperty("event.update"), args);
		if (effectedRows > 0) {
			return environment.getProperty("event.update.success");
		} else {
			return environment.getProperty("event.update.fail");
		}
	}

	public String deleteEvent(int eventId) {
		int effectedRows = 0;
		Object[] args = { eventId };
		effectedRows = jdbcTemplate.update(environment.getProperty("event.delete"), args);
		if (effectedRows > 0) {
			return environment.getProperty("event.delete.success");
		} else {
			return environment.getProperty("event.delete.fail");
		}
	}
}
