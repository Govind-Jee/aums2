package com.aums.models;

import java.sql.Date;

public class Student {
    private String regno;
    private String full_name;
    private String father_name;
    private String mother_name;
    private Date dob;
    private String srm_email;
    private String gender;
    private String aadhar;
    private double class_x_percentage;
    private double class_xii_percentage;
    private String course_id;
    private String department_id;
    private String branch;
    private int semester;
    private String section_id;
    private String address;
    private String hostel_id;
    private int room_no;

    public String getRegno() { return regno; }

    public void setRegno(String regno) { this.regno = regno; }

    public String getFull_name() { return full_name; }

    public void setFull_name(String full_name) { this.full_name = full_name; }

    public String getFather_name() { return father_name; }

    public void setFather_name(String father_name) { this.father_name = father_name; }

    public String getMother_name() { return mother_name; }

    public void setMother_name(String mother_name) { this.mother_name = mother_name; }

    public Date getDob() { return dob; }

    public void setDob(Date dob) { this.dob = dob; }

    public String getSrm_email() { return srm_email; }

    public void setSrm_email(String srm_email) { this.srm_email = srm_email; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getAadhar() { return aadhar; }

    public void setAadhar(String aadhar) { this.aadhar = aadhar; }

    public double getClass_x_percentage() { return class_x_percentage; }

    public void setClass_x_percentage(double class_x_percentage) { this.class_x_percentage = class_x_percentage; }

    public double getClass_xii_percentage() { return class_xii_percentage; }

    public void setClass_xii_percentage(double class_xii_percentage) { this.class_xii_percentage = class_xii_percentage; }

    public String getCourse_id() { return course_id; }

    public void setCourse_id(String course_id) { this.course_id = course_id; }

    public String getDepartment_id() { return department_id; }

    public void setDepartment_id(String department_id) { this.department_id = department_id; }

    public String getBranch() { return branch; }

    public void setBranch(String branch) { this.branch = branch; }

    public int getSemester() { return semester; }

    public void setSemester(int semester) { this.semester = semester; }

    public String getSection_id() { return section_id; }

    public void setSection_id(String section_id) { this.section_id = section_id; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getHostel_id() { return hostel_id; }

    public void setHostel_id(String hostel_id) { this.hostel_id = hostel_id; }

    public int getRoom_no() { return room_no; }

    public void setRoom_no(int room_no) { this.room_no = room_no; }
}
