package com.aums.gui;

import com.aums.dao.FacultyEmailDAO;
import com.aums.models.FacultyEmail;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class FacultyEmailPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private FacultyEmailDAO dao = new FacultyEmailDAO();

    public FacultyEmailPanel() {
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
        model.setColumnIdentifiers(new Object[]{"faculty_id", "personal_email"});
        loadData();
    }

    private void loadData() {
        try {
            List<FacultyEmail> list = dao.getAll();
            model.setRowCount(0);
            for (FacultyEmail obj : list) {
                model.addRow(new Object[]{obj.getFaculty_id(), obj.getPersonal_email()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
