package com.aums.dao;

import com.aums.models.Department;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class DepartmentDAO {
    public List<Department> getAll() throws SQLException {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM department";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Department obj = new Department();
                obj.setDepartment_id(rs.getString("department_id"));
                obj.setDepartment_name(rs.getString("department_name"));
                obj.setCampus_location(rs.getString("campus_location"));
                list.add(obj);
            }
        }
        return list;
    }
}
