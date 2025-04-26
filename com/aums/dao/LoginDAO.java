//package com.aums.dao;
//
//import com.aums.models.Login;
//import com.aums.utils.DBConnection;
//import java.sql.*;
//
//public class LoginDAO {
//    public Login authenticate(String userId, String passwordHash) throws SQLException {
//        String sql = "SELECT l.faculty_id, l.user_id, l.password_hash, l.role, f.FA_section " +
//                     "FROM login l LEFT JOIN faculty f ON l.faculty_id = f.faculty_id " +
//                     "WHERE l.user_id = ? AND l.password_hash = ?";
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, userId);
//            ps.setString(2, passwordHash);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    Login login = new Login();
//                    login.setFaculty_id(rs.getInt("faculty_id"));
//                    login.setUser_id(rs.getString("user_id"));
//                    login.setPassword_hash(rs.getString("password_hash"));
//                    login.setRole(rs.getString("role"));
//                    login.setFaSection(rs.getString("FA_section"));
//                    return login;
//                } else {
//                    return null;
//                }
//            }
//        }
//    }
//}
package com.aums.dao;

import com.aums.models.Login;
import com.aums.utils.DBConnection;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    /**
     * Fetches all login records, including FA_section if present.
     * Handles SQLException internally so callers don't need to catch.
     */
    public List<Login> getAll() {
        List<Login> list = new ArrayList<>();
        String sql = """
            SELECT l.faculty_id,
                   l.user_id,
                   l.password_hash,
                   l.role,
                   f.FA_section
              FROM login l
              LEFT JOIN faculty f ON l.faculty_id = f.faculty_id
        """;

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Login obj = new Login();
                obj.setFaculty_id(rs.getInt("faculty_id"));
                obj.setUser_id(rs.getString("user_id"));
                obj.setPassword_hash(rs.getString("password_hash"));
                obj.setRole(rs.getString("role"));
                obj.setFaSection(rs.getString("FA_section"));
                list.add(obj);
            }
        } catch (SQLException e) {
            // Log or alert, but do not rethrow
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                null,
                "Error fetching login data:\n" + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }

        return list;
    }

    /**
     * Authenticates a user by user_id + password_hash and returns
     * their Login object (including FA_section), or null if invalid.
     * Throws SQLException so callers can handle login failures.
     */
    public Login authenticate(String userId, String passwordHash) throws SQLException {
        String sql = """
            SELECT l.faculty_id,
                   l.user_id,
                   l.password_hash,
                   l.role,
                   f.FA_section
              FROM login l
              LEFT JOIN faculty f ON l.faculty_id = f.faculty_id
             WHERE l.user_id = ?
               AND l.password_hash = ?
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, userId);
            ps.setString(2, passwordHash);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Login login = new Login();
                    login.setFaculty_id(rs.getInt("faculty_id"));
                    login.setUser_id(rs.getString("user_id"));
                    login.setPassword_hash(rs.getString("password_hash"));
                    login.setRole(rs.getString("role"));
                    login.setFaSection(rs.getString("FA_section"));
                    return login;
                }
            }
        }

        return null;
    }
}
