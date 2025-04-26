package com.aums.dao;

import com.aums.models.NoticeBoard;
import com.aums.utils.DBConnection;
import java.sql.*;
import java.util.*;

public class NoticeBoardDAO {
    public List<NoticeBoard> getAll() throws SQLException {
        List<NoticeBoard> list = new ArrayList<>();
        String sql = "SELECT * FROM notice_board";
        try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                NoticeBoard obj = new NoticeBoard();
                obj.setNotice_id(rs.getString("notice_id"));
                obj.setDepartment_id(rs.getString("department_id"));
                obj.setDate_posted(rs.getDate("date_posted"));
                obj.setContent(rs.getString("content"));
                list.add(obj);
            }
        }
        return list;
    }
}
