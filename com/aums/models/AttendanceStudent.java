package com.aums.models;

import java.sql.Date;

public class AttendanceStudent {
    private String regno;
    private Date attendance_date;
    private String subject_id;
    private String first_hr;
    private String second_hr;

    public String getRegno() { return regno; }

    public void setRegno(String regno) { this.regno = regno; }

    public Date getAttendance_date() { return attendance_date; }

    public void setAttendance_date(Date attendance_date) { this.attendance_date = attendance_date; }

    public String getSubject_id() { return subject_id; }

    public void setSubject_id(String subject_id) { this.subject_id = subject_id; }

    public String getFirst_hr() { return first_hr; }

    public void setFirst_hr(String first_hr) { this.first_hr = first_hr; }

    public String getSecond_hr() { return second_hr; }

    public void setSecond_hr(String second_hr) { this.second_hr = second_hr; }
}
