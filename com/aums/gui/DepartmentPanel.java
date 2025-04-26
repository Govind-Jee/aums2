package com.aums.gui;

import com.aums.dao.DepartmentDAO;
import com.aums.models.Department;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class DepartmentPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private DepartmentDAO dao = new DepartmentDAO();

    public DepartmentPanel() {
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
        model.setColumnIdentifiers(new Object[]{"department_id", "department_name", "campus_location"});
        loadData();
    }

    private void loadData() {
        try {
            List<Department> list = dao.getAll();
            model.setRowCount(0);
            for (Department obj : list) {
                model.addRow(new Object[]{obj.getDepartment_id(), obj.getDepartment_name(), obj.getCampus_location()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
