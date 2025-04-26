package com.aums.models;

import java.sql.Date;

public class Faculty {
    private int faculty_id;
    private String full_name;
    private Date doj;
    private String srm_email;
    private String address;
    private String aadhar;
    private String department_id;
    private String FA_section;

    public int getFaculty_id() { return faculty_id; }

    public void setFaculty_id(int faculty_id) { this.faculty_id = faculty_id; }

    public String getFull_name() { return full_name; }

    public void setFull_name(String full_name) { this.full_name = full_name; }

    public Date getDoj() { return doj; }

    public void setDoj(Date doj) { this.doj = doj; }

    public String getSrm_email() { return srm_email; }

    public void setSrm_email(String srm_email) { this.srm_email = srm_email; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getAadhar() { return aadhar; }

    public void setAadhar(String aadhar) { this.aadhar = aadhar; }

    public String getDepartment_id() { return department_id; }

    public void setDepartment_id(String department_id) { this.department_id = department_id; }

    public String getFA_section() { return FA_section; }

    public void setFA_section(String FA_section) { this.FA_section = FA_section; }
}
