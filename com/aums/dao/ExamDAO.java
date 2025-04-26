package com.aums.dao;

import com.aums.models.Exam;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class ExamDAO {
    public List<Exam> getAll() throws SQLException {
        List<Exam> list = new ArrayList<>();
        String sql = "SELECT * FROM exam";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Exam obj = new Exam();
                obj.setExam_code(rs.getString("exam_code"));
                obj.setExam_date(rs.getDate("exam_date"));
                obj.setExam_time(rs.getTime("exam_time"));
                obj.setRoom_no(rs.getInt("room_no"));
                obj.setSubject_id(rs.getString("subject_id"));
                list.add(obj);
            }
        }
        return list;
    }
}
