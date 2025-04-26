package com.aums.dao;

import com.aums.models.AttendanceStudent;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class AttendanceStudentDAO {
    public List<AttendanceStudent> getAll() throws SQLException {
        List<AttendanceStudent> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance_student";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                AttendanceStudent obj = new AttendanceStudent();
                obj.setRegno(rs.getString("regno"));
                obj.setAttendance_date(rs.getDate("attendance_date"));
                obj.setSubject_id(rs.getString("subject_id"));
                obj.setFirst_hr(rs.getString("first_hr"));
                obj.setSecond_hr(rs.getString("second_hr"));
                list.add(obj);
            }
        }
        return list;
    }
}
