package com.aums.dao;

import com.aums.models.AdminDetails;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class AdminDetailsDAO {
    public List<AdminDetails> getAll() throws SQLException {
        List<AdminDetails> list = new ArrayList<>();
        String sql = "SELECT * FROM admin_details";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                AdminDetails obj = new AdminDetails();
                obj.setUser_id(rs.getString("user_id"));
                obj.setDesignation(rs.getString("designation"));
                obj.setAdmin_name(rs.getString("admin_name"));
                obj.setPhone_number(rs.getString("phone_number"));
                obj.setPersonal_email(rs.getString("personal_email"));
                obj.setSrm_email(rs.getString("srm_email"));
                list.add(obj);
            }
        }
        return list;
    }
}
