package com.aums.dao;

import com.aums.models.FacultyPhone;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class FacultyPhoneDAO {
    public List<FacultyPhone> getAll() throws SQLException {
        List<FacultyPhone> list = new ArrayList<>();
        String sql = "SELECT * FROM faculty_phone";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                FacultyPhone obj = new FacultyPhone();
                obj.setFaculty_id(rs.getInt("faculty_id"));
                obj.setPhone_number(rs.getString("phone_number"));
                list.add(obj);
            }
        }
        return list;
    }
}
