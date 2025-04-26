package com.aums.dao;

import com.aums.models.StudentClub;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class StudentClubDAO {
    public List<StudentClub> getAll() throws SQLException {
        List<StudentClub> list = new ArrayList<>();
        String sql = "SELECT * FROM student_club";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StudentClub obj = new StudentClub();
                obj.setMembership_id(rs.getInt("membership_id"));
                obj.setRegno(rs.getString("regno"));
                obj.setClub_id(rs.getString("club_id"));
                obj.setJoining_date(rs.getDate("joining_date"));
                list.add(obj);
            }
        }
        return list;
    }
}
