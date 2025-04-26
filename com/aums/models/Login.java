package com.aums.models;

public class Login {
    private Integer faculty_id;
    private String user_id;
    private String password_hash;
    private String role;
    private String faSection;

    public Integer getFaculty_id() { return faculty_id; }
    public void setFaculty_id(Integer faculty_id) { this.faculty_id = faculty_id; }
    public String getUser_id() { return user_id; }
    public void setUser_id(String user_id) { this.user_id = user_id; }
    public String getPassword_hash() { return password_hash; }
    public void setPassword_hash(String password_hash) { this.password_hash = password_hash; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getFaSection() { return faSection; }
    public void setFaSection(String faSection) { this.faSection = faSection; }
}
