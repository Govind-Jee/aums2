package com.aums.models;



public class Course {
    private String course_id;
    private String course_name;
    private int duration_months;
    private String department_id;

    public String getCourse_id() { return course_id; }

    public void setCourse_id(String course_id) { this.course_id = course_id; }

    public String getCourse_name() { return course_name; }

    public void setCourse_name(String course_name) { this.course_name = course_name; }

    public int getDuration_months() { return duration_months; }

    public void setDuration_months(int duration_months) { this.duration_months = duration_months; }

    public String getDepartment_id() { return department_id; }

    public void setDepartment_id(String department_id) { this.department_id = department_id; }
}
