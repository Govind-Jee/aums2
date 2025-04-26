package com.aums.dao;

import com.aums.models.FacultyTeaches;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class FacultyTeachesDAO {
    public List<FacultyTeaches> getAll() throws SQLException {
        List<FacultyTeaches> list = new ArrayList<>();
        String sql = "SELECT * FROM faculty_teaches";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                FacultyTeaches obj = new FacultyTeaches();
                obj.setFaculty_id(rs.getInt("faculty_id"));
                obj.setSection_id(rs.getString("section_id"));
                obj.setSubject_id(rs.getString("subject_id"));
                list.add(obj);
            }
        }
        return list;
    }
}
