package com.aums.gui;

import com.aums.dao.ClubDetailsDAO;
import com.aums.models.ClubDetails;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ClubDetailsPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private ClubDetailsDAO dao = new ClubDetailsDAO();

    public ClubDetailsPanel() {
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
        model.setColumnIdentifiers(new Object[]{"club_id", "club_name", "faculty_id"});
        loadData();
    }

    private void loadData() {
        try {
            List<ClubDetails> list = dao.getAll();
            model.setRowCount(0);
            for (ClubDetails obj : list) {
                model.addRow(new Object[]{obj.getClub_id(), obj.getClub_name(), obj.getFaculty_id()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
