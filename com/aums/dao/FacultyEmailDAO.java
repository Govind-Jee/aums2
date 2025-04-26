package com.aums.dao;

import com.aums.models.FacultyEmail;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class FacultyEmailDAO {
    public List<FacultyEmail> getAll() throws SQLException {
        List<FacultyEmail> list = new ArrayList<>();
        String sql = "SELECT * FROM faculty_email";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                FacultyEmail obj = new FacultyEmail();
                obj.setFaculty_id(rs.getInt("faculty_id"));
                obj.setPersonal_email(rs.getString("personal_email"));
                list.add(obj);
            }
        }
        return list;
    }
}
