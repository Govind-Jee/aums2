package com.aums.dao;

import com.aums.models.Hostel;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class HostelDAO {
    public List<Hostel> getAll() throws SQLException {
        List<Hostel> list = new ArrayList<>();
        String sql = "SELECT * FROM hostel";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Hostel obj = new Hostel();
                obj.setHostel_id(rs.getString("hostel_id"));
                obj.setHostel_name(rs.getString("hostel_name"));
                obj.setWarden_name(rs.getString("warden_name"));
                list.add(obj);
            }
        }
        return list;
    }
}
