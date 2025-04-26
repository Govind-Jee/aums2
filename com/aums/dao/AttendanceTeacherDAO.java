package com.aums.dao;

import com.aums.models.AttendanceTeacher;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class AttendanceTeacherDAO {
    public List<AttendanceTeacher> getAll() throws SQLException {
        List<AttendanceTeacher> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance_teacher";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                AttendanceTeacher obj = new AttendanceTeacher();
                obj.setFaculty_id(rs.getInt("faculty_id"));
                obj.setAttendance_date(rs.getDate("attendance_date"));
                obj.setStatus(rs.getString("status"));
                list.add(obj);
            }
        }
        return list;
    }
}
