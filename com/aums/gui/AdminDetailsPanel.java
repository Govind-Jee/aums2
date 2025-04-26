package com.aums.gui;

import com.aums.dao.AdminDetailsDAO;
import com.aums.models.AdminDetails;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class AdminDetailsPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private AdminDetailsDAO dao = new AdminDetailsDAO();

    public AdminDetailsPanel() {
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
        model.setColumnIdentifiers(new Object[]{"user_id", "designation", "admin_name", "phone_number", "personal_email", "srm_email"});
        loadData();
    }

    private void loadData() {
        try {
            List<AdminDetails> list = dao.getAll();
            model.setRowCount(0);
            for (AdminDetails obj : list) {
                model.addRow(new Object[]{obj.getUser_id(), obj.getDesignation(), obj.getAdmin_name(), obj.getPhone_number(), obj.getPersonal_email(), obj.getSrm_email()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
