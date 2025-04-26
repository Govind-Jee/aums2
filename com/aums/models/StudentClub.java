package com.aums.models;

import java.sql.Date;

public class StudentClub {
    private int membership_id;
    private String regno;
    private String club_id;
    private Date joining_date;

    public int getMembership_id() { return membership_id; }

    public void setMembership_id(int membership_id) { this.membership_id = membership_id; }

    public String getRegno() { return regno; }

    public void setRegno(String regno) { this.regno = regno; }

    public String getClub_id() { return club_id; }

    public void setClub_id(String club_id) { this.club_id = club_id; }

    public Date getJoining_date() { return joining_date; }

    public void setJoining_date(Date joining_date) { this.joining_date = joining_date; }
}
