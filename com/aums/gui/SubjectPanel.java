package com.aums.gui;

import com.aums.dao.SubjectDAO;
import com.aums.models.Subject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class SubjectPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private SubjectDAO dao = new SubjectDAO();

    public SubjectPanel() {
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
        model.setColumnIdentifiers(new Object[]{"subject_id", "subject_name", "course_id"});
        loadData();
    }

    private void loadData() {
        try {
            List<Subject> list = dao.getAll();
            model.setRowCount(0);
            for (Subject obj : list) {
                model.addRow(new Object[]{obj.getSubject_id(), obj.getSubject_name(), obj.getCourse_id()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
