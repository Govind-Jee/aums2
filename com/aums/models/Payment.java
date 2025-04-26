package com.aums.models;

import java.sql.Date;

public class Payment {
    private int payment_id;
    private String regno;
    private String course_id;
    private double course_fee;
    private String hostel_id;
    private double hostel_fee;
    private Date payment_date;

    public int getPayment_id() { return payment_id; }

    public void setPayment_id(int payment_id) { this.payment_id = payment_id; }

    public String getRegno() { return regno; }

    public void setRegno(String regno) { this.regno = regno; }

    public String getCourse_id() { return course_id; }

    public void setCourse_id(String course_id) { this.course_id = course_id; }

    public double getCourse_fee() { return course_fee; }

    public void setCourse_fee(double course_fee) { this.course_fee = course_fee; }

    public String getHostel_id() { return hostel_id; }

    public void setHostel_id(String hostel_id) { this.hostel_id = hostel_id; }

    public double getHostel_fee() { return hostel_fee; }

    public void setHostel_fee(double hostel_fee) { this.hostel_fee = hostel_fee; }

    public Date getPayment_date() { return payment_date; }

    public void setPayment_date(Date payment_date) { this.payment_date = payment_date; }
}
