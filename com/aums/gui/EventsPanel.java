package com.aums.gui;

import com.aums.dao.EventsDAO;
import com.aums.models.Events;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class EventsPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private EventsDAO dao = new EventsDAO();

    public EventsPanel() {
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
        model.setColumnIdentifiers(new Object[]{"event_id", "event_date", "duration_minutes", "club_id"});
        loadData();
    }

    private void loadData() {
        try {
            List<Events> list = dao.getAll();
            model.setRowCount(0);
            for (Events obj : list) {
                model.addRow(new Object[]{obj.getEvent_id(), obj.getEvent_date(), obj.getDuration_minutes(), obj.getClub_id()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
