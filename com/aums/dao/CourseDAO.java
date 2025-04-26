package com.aums.dao;

import com.aums.models.Course;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class CourseDAO {
    public List<Course> getAll() throws SQLException {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM course";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Course obj = new Course();
                obj.setCourse_id(rs.getString("course_id"));
                obj.setCourse_name(rs.getString("course_name"));
                obj.setDuration_months(rs.getInt("duration_months"));
                obj.setDepartment_id(rs.getString("department_id"));
                list.add(obj);
            }
        }
        return list;
    }
}
