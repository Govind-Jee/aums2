package com.aums.dao;

import com.aums.models.Faculty;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class FacultyDAO {
    public List<Faculty> getAll() throws SQLException {
        List<Faculty> list = new ArrayList<>();
        String sql = "SELECT * FROM faculty";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Faculty obj = new Faculty();
                obj.setFaculty_id(rs.getInt("faculty_id"));
                obj.setFull_name(rs.getString("full_name"));
                obj.setDoj(rs.getDate("doj"));
                obj.setSrm_email(rs.getString("srm_email"));
                obj.setAddress(rs.getString("address"));
                obj.setAadhar(rs.getString("aadhar"));
                obj.setDepartment_id(rs.getString("department_id"));
                obj.setFA_section(rs.getString("FA_section"));
                list.add(obj);
            }
        }
        return list;
    }
}
