package com.stech.meetat.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stech.meetat.core.CustomDateFormatter;
import com.stech.meetat.core.DayTimeChunks;
import com.stech.meetat.core.TimeFormat;
import com.stech.meetat.dao.EventDao;
import com.stech.meetat.dao.RoomDao;
import com.stech.meetat.pojo.BookingInfo;
import com.stech.meetat.pojo.EventDetails;
import com.stech.meetat.pojo.RoomDetails;
import com.stech.meetat.pojo.ScheduleDetails;
import com.stech.meetat.service.DisplayService;
import com.stech.meetat.util.impl.EventOccurrenceDates;

@Service("displayService")
public class DisplayServiceImpl implements DisplayService {

	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private RoomDao roomDao;
	
	private static Calendar calendar = Calendar.getInstance();
	
	public List<ScheduleDetails> getTodaysSchedule() {
		List<ScheduleDetails> scheduleDetailsList = new ArrayList<ScheduleDetails>();
		Date todayDate = new Date();
		int locationId = 1;
		List<RoomDetails> roomDetailsList = roomDao.getRooms(locationId);
		for(RoomDetails roomDetails : roomDetailsList){
			List<EventDetails> allEventsOfARoom = eventDao.getEvents(locationId, roomDetails.getId());
			ScheduleDetails scheduleDetails = new ScheduleDetails();
			scheduleDetails.setRoom(roomDetails.getName());
			List<BookingInfo> bookingInfo = getBookingInfo(allEventsOfARoom, todayDate);
			scheduleDetails.setBookingInfo(bookingInfo);
			scheduleDetailsList.add(scheduleDetails);
		}
		return scheduleDetailsList;
	}

	public List<ScheduleDetails> getScheduleForDate(Date date) {
		List<ScheduleDetails> scheduleDetailsList = new ArrayList<ScheduleDetails>();
		int locationId = 1;
		List<RoomDetails> roomDetailsList = roomDao.getRooms(locationId);
		for(RoomDetails roomDetails : roomDetailsList){
			List<EventDetails> allEventsOfARoom = eventDao.getEvents(locationId, roomDetails.getId());
			ScheduleDetails scheduleDetails = new ScheduleDetails();
			scheduleDetails.setRoom(roomDetails.getName());
			List<BookingInfo> bookingInfo = getBookingInfo(allEventsOfARoom, date);
			scheduleDetails.setBookingInfo(bookingInfo);
			scheduleDetailsList.add(scheduleDetails);
		}
		return scheduleDetailsList;
	}

	public Map<Date, List<ScheduleDetails>> getScheduleForDateRange(Date startDate, Date endDate) {
		int locationId = 1;
		Map<Date, List<ScheduleDetails>> scheduleOfDateRange = new HashMap<Date, List<ScheduleDetails>>();
		calendar.setTime(startDate);
		Date date = startDate;
		while (calendar.getTime().before(endDate) 
				|| calendar.getTime().equals(endDate)) {
		List<ScheduleDetails> scheduleDetailsList = new ArrayList<ScheduleDetails>();
		List<RoomDetails> roomDetailsList = roomDao.getRooms(locationId);
		for(RoomDetails roomDetails : roomDetailsList) {
			List<EventDetails> allEventsOfARoom = eventDao.getEvents(locationId, roomDetails.getId());
			ScheduleDetails scheduleDetails = new ScheduleDetails();
			scheduleDetails.setRoom(roomDetails.getName());
			List<BookingInfo> bookingInfo = getBookingInfo(allEventsOfARoom, date);
			scheduleDetails.setBookingInfo(bookingInfo);
			scheduleDetailsList.add(scheduleDetails);
		}
		scheduleOfDateRange.put(date, scheduleDetailsList);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		return scheduleOfDateRange;
	}
	

	public void getScheduleOfARoom(String roomId) {
		// TODO Auto-generated method stub
		
	}

	public void getConfictDetails(String roomId, Date date, int timeId) {
		// TODO Auto-generated method stub
		
	}

	public void getScheduleOfAnEvent(String eventId) {
		// TODO Auto-generated method stub
		
	}
	
	private List<BookingInfo> getBookingInfo(List<EventDetails> events, Date date) {
		DayTimeChunks dayTimeChunks = new DayTimeChunks(TimeFormat.Hrs12);
		Map<String, Integer> timeChunks = dayTimeChunks.getTimeChunks();
		CustomDateFormatter dateFormatter = new CustomDateFormatter();
		List<BookingInfo> bookingInfoList = new ArrayList<BookingInfo>();
		
		/*System.out.println("Total Events Booked for a Room: "+events.size());*/
		
		int timeTracker = 0;		
		Map<Integer, EventDetails> timeIdConfirmedEventMap = new HashMap<Integer,EventDetails>();
		List<EventDetails> conflictEvents = new ArrayList<EventDetails>();
		//Iterate through all events booked for a particular room
		for(EventDetails eventDetails : events) {
			int startTimeId = eventDetails.getStartTimeId();
			int duration = (eventDetails.getEndTimeId() - eventDetails.getStartTimeId());
			EventOccurrenceDates eoDates = new EventOccurrenceDates(eventDetails, date);
			List<String> possibleDates = eoDates.getDates();
			//check input date included in possible occurrence dates
			if(possibleDates.contains(dateFormatter.formatToString(date))) {
				/*System.out.println("Booked Event: "+eventDetails);*/
				if (timeTracker > timeChunks.size()) {
					//Special Category.. Need to Consider next day time line
					System.out.println("Special Category.. Need to Consider next day time line");
					break;
				} else if (timeTracker < startTimeId) {
					timeIdConfirmedEventMap.put(startTimeId, eventDetails);
					timeTracker += startTimeId + duration - 1;
				} else {
					// push this into queue / set as conflict event
					conflictEvents.add(eventDetails);
				}
			}
		}
		
		/*System.out.println("Date: "+date);
		System.out.println("conflict Events Size: "+conflictEvents.size());
		System.out.println("conflict Events: "+conflictEvents);
		
		System.out.println("confirmed Events Size: "+timeEventMap.size());*/
		
		for(int i = 0; i < timeChunks.size(); i++) {
			BookingInfo bookingInfo = new BookingInfo();
			bookingInfo.setTimeChunkId(i);
			if(timeIdConfirmedEventMap.keySet().contains(i)) {
				EventDetails confirmedEventDetails = timeIdConfirmedEventMap.get(i);
				int duration = (confirmedEventDetails.getEndTimeId() - confirmedEventDetails.getStartTimeId());
				bookingInfo.setIsAvailable(false);
				bookingInfo.setEvent(confirmedEventDetails);
				bookingInfo.setDuration(duration);
				i+=(duration-1);
			} else {
				bookingInfo.setIsAvailable(true);
			}
			bookingInfoList.add(bookingInfo);
		}
		return bookingInfoList;
	}
}
