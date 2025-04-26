package com.aums.gui;

import com.aums.dao.StudentPhoneDAO;
import com.aums.models.StudentPhone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class StudentPhonePanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private StudentPhoneDAO dao = new StudentPhoneDAO();

    public StudentPhonePanel() {
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
        model.setColumnIdentifiers(new Object[]{"regno", "phone_number"});
        loadData();
    }

    private void loadData() {
        try {
            List<StudentPhone> list = dao.getAll();
            model.setRowCount(0);
            for (StudentPhone obj : list) {
                model.addRow(new Object[]{obj.getRegno(), obj.getPhone_number()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
