package com.aums.gui;

import com.aums.dao.LoginDAO;
import com.aums.models.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class LoginPanel extends JPanel {
    private final JTable table;
    private final DefaultTableModel model;
    private final LoginDAO dao = new LoginDAO();

    public LoginPanel() {
        setLayout(new BorderLayout());

        // Table setup
        model = new DefaultTableModel();
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Refresh button
        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> loadData());
        JPanel top = new JPanel();
        top.add(refresh);
        add(top, BorderLayout.NORTH);

        // Define columns and load initial data
        model.setColumnIdentifiers(new Object[]{"faculty_id", "user_id", "password_hash", "role"});
        loadData();
    }

    private void loadData() {
        // No SQLException to catch here—LoginDAO#getAll() handles it internally
        List<Login> list = dao.getAll();
        model.setRowCount(0);
        for (Login login : list) {
            model.addRow(new Object[]{
                login.getFaculty_id(),
                login.getUser_id(),
                login.getPassword_hash(),
                login.getRole()
            });
        }
    }
}
