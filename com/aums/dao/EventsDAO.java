package com.aums.dao;

import com.aums.models.Events;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class EventsDAO {
    public List<Events> getAll() throws SQLException {
        List<Events> list = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Events obj = new Events();
                obj.setEvent_id(rs.getString("event_id"));
                obj.setEvent_date(rs.getDate("event_date"));
                obj.setDuration_minutes(rs.getInt("duration_minutes"));
                obj.setClub_id(rs.getString("club_id"));
                list.add(obj);
            }
        }
        return list;
    }
}
