package com.aums.gui;

import com.aums.dao.FacultyDAO;
import com.aums.models.Faculty;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class FacultyPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private FacultyDAO dao = new FacultyDAO();

    public FacultyPanel() {
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
        model.setColumnIdentifiers(new Object[]{"faculty_id", "full_name", "doj", "srm_email", "address", "aadhar", "department_id", "FA_section"});
        loadData();
    }

    private void loadData() {
        try {
            List<Faculty> list = dao.getAll();
            model.setRowCount(0);
            for (Faculty obj : list) {
                model.addRow(new Object[]{obj.getFaculty_id(), obj.getFull_name(), obj.getDoj(), obj.getSrm_email(), obj.getAddress(), obj.getAadhar(), obj.getDepartment_id(), obj.getFA_section()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
