package com.stech.meetat.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.stech.meetat.pojo.EventDetails;

public class EventDetailsRowMapper implements RowMapper<EventDetails> {

	public EventDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		EventDetails eventDetails = new EventDetails();
		eventDetails.setId(rs.getInt("id"));
		eventDetails.setRoomId(rs.getInt("conference_room_id"));
		eventDetails.setLocationId(rs.getInt("location_id"));
		eventDetails.setName(rs.getString("name"));
		eventDetails.setDescription(rs.getString("description"));
		eventDetails.setCreatedUserId(rs.getInt("created_user_id"));
		eventDetails.setOwner(rs.getString("owner"));
		String attendees = rs.getString("attendees");
		String[] attendeesArray = StringUtils.split(attendees, ",");
		eventDetails.setAttendees(Arrays.asList(attendeesArray));
		eventDetails.setRecurrenceType(rs.getString("recurrence_type"));
		eventDetails.setStartDate(rs.getDate("start_date"));
		eventDetails.setStartTimeId(rs.getInt("start_time"));
		eventDetails.setEndTimeId(rs.getInt("end_time"));
		eventDetails.setEndDate(rs.getDate("end_date"));
		eventDetails.setLastOccurrence(rs.getDate("last_occurrence"));
		return eventDetails;
	}

}
