package com.aums.dao;

import com.aums.models.Payment;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class PaymentDAO {
    public List<Payment> getAll() throws SQLException {
        List<Payment> list = new ArrayList<>();
        String sql = "SELECT * FROM payment";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Payment obj = new Payment();
                obj.setPayment_id(rs.getInt("payment_id"));
                obj.setRegno(rs.getString("regno"));
                obj.setCourse_id(rs.getString("course_id"));
                obj.setCourse_fee(rs.getDouble("course_fee"));
                obj.setHostel_id(rs.getString("hostel_id"));
                obj.setHostel_fee(rs.getDouble("hostel_fee"));
                obj.setPayment_date(rs.getDate("payment_date"));
                list.add(obj);
            }
        }
        return list;
    }
}
