package com.aums.gui;

import com.aums.dao.FacultyTeachesDAO;
import com.aums.models.FacultyTeaches;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class FacultyTeachesPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private FacultyTeachesDAO dao = new FacultyTeachesDAO();

    public FacultyTeachesPanel() {
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
        model.setColumnIdentifiers(new Object[]{"faculty_id", "section_id", "subject_id"});
        loadData();
    }

    private void loadData() {
        try {
            List<FacultyTeaches> list = dao.getAll();
            model.setRowCount(0);
            for (FacultyTeaches obj : list) {
                model.addRow(new Object[]{obj.getFaculty_id(), obj.getSection_id(), obj.getSubject_id()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
