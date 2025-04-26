package com.aums.gui;

import com.aums.dao.AttendanceStudentDAO;
import com.aums.models.AttendanceStudent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class AttendanceStudentPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private AttendanceStudentDAO dao = new AttendanceStudentDAO();

    public AttendanceStudentPanel() {
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
        model.setColumnIdentifiers(new Object[]{"regno", "attendance_date", "subject_id", "first_hr", "second_hr"});
        loadData();
    }

    private void loadData() {
        try {
            List<AttendanceStudent> list = dao.getAll();
            model.setRowCount(0);
            for (AttendanceStudent obj : list) {
                model.addRow(new Object[]{obj.getRegno(), obj.getAttendance_date(), obj.getSubject_id(), obj.getFirst_hr(), obj.getSecond_hr()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
