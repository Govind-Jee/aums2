package com.aums.models;

import java.sql.Date;

public class AttendanceTeacher {
    private int faculty_id;
    private Date attendance_date;
    private String status;

    public int getFaculty_id() { return faculty_id; }

    public void setFaculty_id(int faculty_id) { this.faculty_id = faculty_id; }

    public Date getAttendance_date() { return attendance_date; }

    public void setAttendance_date(Date attendance_date) { this.attendance_date = attendance_date; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
