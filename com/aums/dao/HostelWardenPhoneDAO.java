package com.aums.dao;

import com.aums.models.HostelWardenPhone;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class HostelWardenPhoneDAO {
    public List<HostelWardenPhone> getAll() throws SQLException {
        List<HostelWardenPhone> list = new ArrayList<>();
        String sql = "SELECT * FROM hostel_warden_phone";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                HostelWardenPhone obj = new HostelWardenPhone();
                obj.setHostel_id(rs.getString("hostel_id"));
                obj.setPhone_number(rs.getString("phone_number"));
                list.add(obj);
            }
        }
        return list;
    }
}
