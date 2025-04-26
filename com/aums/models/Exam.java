package com.aums.models;

import java.sql.Date;
import java.sql.Time;

public class Exam {
    private String exam_code;
    private Date exam_date;
    private Time exam_time;
    private int room_no;
    private String subject_id;

    public String getExam_code() { return exam_code; }

    public void setExam_code(String exam_code) { this.exam_code = exam_code; }

    public Date getExam_date() { return exam_date; }

    public void setExam_date(Date exam_date) { this.exam_date = exam_date; }

    public Time getExam_time() { return exam_time; }

    public void setExam_time(Time exam_time) { this.exam_time = exam_time; }

    public int getRoom_no() { return room_no; }

    public void setRoom_no(int room_no) { this.room_no = room_no; }

    public String getSubject_id() { return subject_id; }

    public void setSubject_id(String subject_id) { this.subject_id = subject_id; }
}
