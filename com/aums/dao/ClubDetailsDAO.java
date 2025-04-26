package com.aums.dao;

import com.aums.models.ClubDetails;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class ClubDetailsDAO {
    public List<ClubDetails> getAll() throws SQLException {
        List<ClubDetails> list = new ArrayList<>();
        String sql = "SELECT * FROM club_details";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ClubDetails obj = new ClubDetails();
                obj.setClub_id(rs.getString("club_id"));
                obj.setClub_name(rs.getString("club_name"));
                obj.setFaculty_id(rs.getInt("faculty_id"));
                list.add(obj);
            }
        }
        return list;
    }
}
