package com.aums.dao;

import com.aums.models.Subject;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class SubjectDAO {
    public List<Subject> getAll() throws SQLException {
        List<Subject> list = new ArrayList<>();
        String sql = "SELECT * FROM subject";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Subject obj = new Subject();
                obj.setSubject_id(rs.getString("subject_id"));
                obj.setSubject_name(rs.getString("subject_name"));
                obj.setCourse_id(rs.getString("course_id"));
                list.add(obj);
            }
        }
        return list;
    }
}
