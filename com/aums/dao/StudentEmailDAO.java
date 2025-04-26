package com.aums.dao;

import com.aums.models.StudentEmail;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class StudentEmailDAO {
    public List<StudentEmail> getAll() throws SQLException {
        List<StudentEmail> list = new ArrayList<>();
        String sql = "SELECT * FROM student_email";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StudentEmail obj = new StudentEmail();
                obj.setRegno(rs.getString("regno"));
                obj.setPersonal_email(rs.getString("personal_email"));
                list.add(obj);
            }
        }
        return list;
    }
}
