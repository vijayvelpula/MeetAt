package com.stech.meetat.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ScheduleDetails {
	
	private String room;
    private List<BookingInfo> bookingInfo;

    public List<BookingInfo> getBookingInfo ()
    {
        return bookingInfo;
    }

    public void setBookingInfo (List<BookingInfo> bookingInfo)
    {
        this.bookingInfo = bookingInfo;
    }

    public String getRoom ()
    {
        return room;
    }

    public void setRoom (String room)
    {
        this.room = room;
    }

    @Override
    public String toString()
    {
        return "ScheduleDetails [ room = "+room+", bookingInfo = "+bookingInfo+"]";
    }
}
