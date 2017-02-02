package com.stech.meetat.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class EventDetails {
	
	private int id;
	private int roomId;
	private int locationId;
	private int createdUserId;
	private String name;
	private String owner;
	private List<String> attendees;
	private String recurrenceType;
	private int startTimeId;
	private int endTimeId;
	private Date startDate;
	private Date lastOccurrence;
	private Date endDate;
	private String description;
	private boolean isActive;
	private String excludedDates;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(int createdUserId) {
		this.createdUserId = createdUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<String> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<String> attendees) {
		this.attendees = attendees;
	}

	public String getRecurrenceType() {
		return recurrenceType;
	}

	public void setRecurrenceType(String recurrenceType) {
		this.recurrenceType = recurrenceType;
	}

	public int getStartTimeId() {
		return startTimeId;
	}

	public void setStartTimeId(int startTimeId) {
		this.startTimeId = startTimeId;
	}

	public int getEndTimeId() {
		return endTimeId;
	}

	public void setEndTimeId(int endTimeId) {
		this.endTimeId = endTimeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLastOccurrence() {
		return lastOccurrence;
	}

	public void setLastOccurrence(Date lastOccurrence) {
		this.lastOccurrence = lastOccurrence;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
    public String toString()
    {
        return "EventDetails ["
        		+" id = " + id 
        		+ ", roomId = " + roomId
        		+ ", locationId = " + locationId
        		+ ", createdUserId = " + createdUserId
        		+ ", name = " + name
        		+ ", owner = " + owner
        		+ ", attendees = " + attendees
        		+ ", recurrenceType = " + recurrenceType
        		+ ", startTimeId = " + startTimeId
        		+ ", endTimeId = " + endTimeId
        		+ ", startDate = " + startDate
        		+ ", lastOccurrence = " + lastOccurrence
        		+ ", endDate = " + endDate
        		+ ", description = " + description
        		+ ", isActive = " + isActive 
        		+ ", excludedDates = " + excludedDates
        		+ "]";
    }
}
