package com.aums.gui;

import com.aums.dao.StudentClubDAO;
import com.aums.models.StudentClub;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class StudentClubPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private StudentClubDAO dao = new StudentClubDAO();

    public StudentClubPanel() {
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
        model.setColumnIdentifiers(new Object[]{"membership_id", "regno", "club_id", "joining_date"});
        loadData();
    }

    private void loadData() {
        try {
            List<StudentClub> list = dao.getAll();
            model.setRowCount(0);
            for (StudentClub obj : list) {
                model.addRow(new Object[]{obj.getMembership_id(), obj.getRegno(), obj.getClub_id(), obj.getJoining_date()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
