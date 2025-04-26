package com.aums.models;

import java.sql.Date;

public class Events {
    private String event_id;
    private Date event_date;
    private int duration_minutes;
    private String club_id;

    public String getEvent_id() { return event_id; }

    public void setEvent_id(String event_id) { this.event_id = event_id; }

    public Date getEvent_date() { return event_date; }

    public void setEvent_date(Date event_date) { this.event_date = event_date; }

    public int getDuration_minutes() { return duration_minutes; }

    public void setDuration_minutes(int duration_minutes) { this.duration_minutes = duration_minutes; }

    public String getClub_id() { return club_id; }

    public void setClub_id(String club_id) { this.club_id = club_id; }
}
