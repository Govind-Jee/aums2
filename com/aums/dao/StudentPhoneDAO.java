package com.aums.dao;

import com.aums.models.StudentPhone;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class StudentPhoneDAO {
    public List<StudentPhone> getAll() throws SQLException {
        List<StudentPhone> list = new ArrayList<>();
        String sql = "SELECT * FROM student_phone";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StudentPhone obj = new StudentPhone();
                obj.setRegno(rs.getString("regno"));
                obj.setPhone_number(rs.getString("phone_number"));
                list.add(obj);
            }
        }
        return list;
    }
}
