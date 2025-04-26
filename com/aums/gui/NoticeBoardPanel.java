package com.aums.gui;

import com.aums.dao.NoticeBoardDAO;
import com.aums.models.NoticeBoard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class NoticeBoardPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private NoticeBoardDAO dao = new NoticeBoardDAO();

    public NoticeBoardPanel() {
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
        model.setColumnIdentifiers(new Object[]{"notice_id", "department_id", "date_posted", "content"});
        loadData();
    }

    private void loadData() {
        try {
            List<NoticeBoard> list = dao.getAll();
            model.setRowCount(0);
            for (NoticeBoard obj : list) {
                model.addRow(new Object[]{obj.getNotice_id(), obj.getDepartment_id(), obj.getDate_posted(), obj.getContent()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
