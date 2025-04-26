package com.aums.dao;

import com.aums.models.Library;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class LibraryDAO {
    public List<Library> getAll() throws SQLException {
        List<Library> list = new ArrayList<>();
        String sql = "SELECT * FROM library";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Library obj = new Library();
                obj.setBook_id(rs.getString("book_id"));
                obj.setTitle(rs.getString("title"));
                obj.setAuthor(rs.getString("author"));
                list.add(obj);
            }
        }
        return list;
    }
}
