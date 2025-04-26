package com.aums.gui;

import com.aums.dao.AttendanceTeacherDAO;
import com.aums.models.AttendanceTeacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class AttendanceTeacherPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private AttendanceTeacherDAO dao = new AttendanceTeacherDAO();

    public AttendanceTeacherPanel() {
        setLayout(new BorderLayout());
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> loadData());
        JPanel top = new JPanel();
        top.add(refresh);
        add(top, BorderLayout.NORTH);

        // Define table columns
        model.setColumnIdentifiers(new Object[]{"faculty_id", "attendance_date", "status"});
        loadData();
    }

    private void loadData() {
        try {
            List<AttendanceTeacher> list = dao.getAll();
            model.setRowCount(0);
            for (AttendanceTeacher obj : list) {
                model.addRow(new Object[]{obj.getFaculty_id(), obj.getAttendance_date(), obj.getStatus()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
