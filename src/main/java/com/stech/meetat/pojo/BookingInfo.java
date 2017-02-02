package com.stech.meetat.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class BookingInfo
{
    private int timeChunkId;

    private EventDetails event;
    
    @JsonInclude(Include.NON_DEFAULT)
    private int duration;

    private boolean isAvailable;

    public int getTimeChunkId ()
    {
        return timeChunkId;
    }

    public void setTimeChunkId (int timeChunkId)
    {
        this.timeChunkId = timeChunkId;
    }

    public EventDetails getEvent ()
    {
        return event;
    }

    public void setEvent (EventDetails event)
    {
        this.event = event;
    }

    public int getDuration ()
    {
        return duration;
    }

    public void setDuration (int duration)
    {
        this.duration = duration;
    }

    public boolean getIsAvailable ()
    {
        return isAvailable;
    }

    public void setIsAvailable (boolean isAvailable)
    {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timeChunkId = "+timeChunkId+", eventDetails = "+event+", duration = "+duration+", isAvailable = "+isAvailable+"]";
    }
}