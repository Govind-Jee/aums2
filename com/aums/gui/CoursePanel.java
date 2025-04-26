package com.aums.gui;

import com.aums.dao.CourseDAO;
import com.aums.models.Course;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class CoursePanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private CourseDAO dao = new CourseDAO();

    public CoursePanel() {
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
        model.setColumnIdentifiers(new Object[]{"course_id", "course_name", "duration_months", "department_id"});
        loadData();
    }

    private void loadData() {
        try {
            List<Course> list = dao.getAll();
            model.setRowCount(0);
            for (Course obj : list) {
                model.addRow(new Object[]{obj.getCourse_id(), obj.getCourse_name(), obj.getDuration_months(), obj.getDepartment_id()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
