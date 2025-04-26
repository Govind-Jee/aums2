package com.aums.dao;

import com.aums.models.StudentLibrary;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class StudentLibraryDAO {
    public List<StudentLibrary> getAll() throws SQLException {
        List<StudentLibrary> list = new ArrayList<>();
        String sql = "SELECT * FROM student_library";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StudentLibrary obj = new StudentLibrary();
                obj.setRegno(rs.getString("regno"));
                obj.setBook_id(rs.getString("book_id"));
                obj.setIssue_date(rs.getDate("issue_date"));
                obj.setReturn_date(rs.getDate("return_date"));
                list.add(obj);
            }
        }
        return list;
    }
}
