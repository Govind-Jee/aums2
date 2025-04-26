package com.aums.dao;

import com.aums.models.Student;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    public List<Student> getAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student obj = new Student();
                obj.setRegno(rs.getString("regno"));
                obj.setFull_name(rs.getString("full_name"));
                obj.setFather_name(rs.getString("father_name"));
                obj.setMother_name(rs.getString("mother_name"));
                obj.setDob(rs.getDate("dob"));
                obj.setSrm_email(rs.getString("srm_email"));
                obj.setGender(rs.getString("gender"));
                obj.setAadhar(rs.getString("aadhar"));
                obj.setClass_x_percentage(rs.getDouble("class_x_percentage"));
                obj.setClass_xii_percentage(rs.getDouble("class_xii_percentage"));
                obj.setCourse_id(rs.getString("course_id"));
                obj.setDepartment_id(rs.getString("department_id"));
                obj.setBranch(rs.getString("branch"));
                obj.setSemester(rs.getInt("semester"));
                obj.setSection_id(rs.getString("section_id"));
                obj.setAddress(rs.getString("address"));
                obj.setHostel_id(rs.getString("hostel_id"));
                obj.setRoom_no(rs.getInt("room_no"));
                list.add(obj);
            }
        }
        return list;
    }
}
