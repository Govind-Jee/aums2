package com.aums.gui;

import com.aums.dao.FacultyPhoneDAO;
import com.aums.models.FacultyPhone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class FacultyPhonePanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private FacultyPhoneDAO dao = new FacultyPhoneDAO();

    public FacultyPhonePanel() {
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
        model.setColumnIdentifiers(new Object[]{"faculty_id", "phone_number"});
        loadData();
    }

    private void loadData() {
        try {
            List<FacultyPhone> list = dao.getAll();
            model.setRowCount(0);
            for (FacultyPhone obj : list) {
                model.addRow(new Object[]{obj.getFaculty_id(), obj.getPhone_number()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
