package com.aums.gui;

import com.aums.dao.StudentLibraryDAO;
import com.aums.models.StudentLibrary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class StudentLibraryPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private StudentLibraryDAO dao = new StudentLibraryDAO();

    public StudentLibraryPanel() {
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
        model.setColumnIdentifiers(new Object[]{"regno", "book_id", "issue_date", "return_date"});
        loadData();
    }

    private void loadData() {
        try {
            List<StudentLibrary> list = dao.getAll();
            model.setRowCount(0);
            for (StudentLibrary obj : list) {
                model.addRow(new Object[]{obj.getRegno(), obj.getBook_id(), obj.getIssue_date(), obj.getReturn_date()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
