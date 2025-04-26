//package com.aums.dao;
//
//import com.aums.models.Marks;
//import com.aums.utils.DBConnection;
//import java.sql.*;
//import java.util.*;
//
//public class MarksDAO {
//    public List<Marks> getAll() throws SQLException {
//        List<Marks> list = new ArrayList<>();
//        String sql = "SELECT * FROM marks";
//        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                Marks obj = new Marks();
//                obj.setRegno(rs.getString("regno"));
//                obj.setSubject_id(rs.getString("subject_id"));
//                obj.setCT1_marks(rs.getDouble("CT1_marks"));
//                obj.setCT2_marks(rs.getDouble("CT2_marks"));
//                list.add(obj);
//            }
//        }
//        return list;
//    }
//}
//
//// NEW: fetch by section
//public java.util.List<Marks> getBySection(String section) throws SQLException {
//    String sql = "SELECT m.regno, m.subject_id, m.CT1_marks, m.CT2_marks " +
//                 "FROM marks m JOIN student s ON m.regno = s.regno WHERE s.section_id = ?";
//    try (java.sql.Connection conn = com.aums.utils.DBConnection.getConnection();
//         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
//        ps.setString(1, section);
//        try (java.sql.ResultSet rs = ps.executeQuery()) {
//            java.util.List<Marks> list = new java.util.ArrayList<>();
//            while (rs.next()) {
//                Marks m = new Marks();
//                m.setRegno(rs.getString("regno"));
//                m.setSubject_id(rs.getString("subject_id"));
//                m.setCT1_marks(rs.getBigDecimal("CT1_marks"));
//                m.setCT2_marks(rs.getBigDecimal("CT2_marks"));
//                list.add(m);
//            }
//            return list;
//        }
//    }
//}
package com.aums.dao;

import com.aums.models.Marks;
import com.aums.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarksDAO {

    /** Fetch all marks records. */
    public List<Marks> getAll() throws SQLException {
        String sql = "SELECT * FROM marks";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            List<Marks> list = new ArrayList<>();
            while (rs.next()) {
                Marks m = new Marks();
                m.setRegno(rs.getString("regno"));
                m.setSubject_id(rs.getString("subject_id"));
                m.setCT1_marks(rs.getDouble("CT1_marks"));
                m.setCT2_marks(rs.getDouble("CT2_marks"));
                list.add(m);
            }
            return list;
        }
    }

    /** Fetch marks for all students in a given section. */
    public List<Marks> getBySection(String section) throws SQLException {
        String sql = """
            SELECT m.regno,
                   m.subject_id,
                   m.CT1_marks,
                   m.CT2_marks
              FROM marks m
              JOIN student s ON m.regno = s.regno
             WHERE s.section_id = ?
            """;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, section);
            try (ResultSet rs = ps.executeQuery()) {
                List<Marks> list = new ArrayList<>();
                while (rs.next()) {
                    Marks m = new Marks();
                    m.setRegno(rs.getString("regno"));
                    m.setSubject_id(rs.getString("subject_id"));
                    m.setCT1_marks(rs.getDouble("CT1_marks"));
                    m.setCT2_marks(rs.getDouble("CT2_marks"));
                    list.add(m);
                }
                return list;
            }
        }
    }
}
