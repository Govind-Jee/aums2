//package com.aums.gui;
//
//import com.aums.dao.MarksDAO;
//import com.aums.models.Marks;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.sql.SQLException;
//import java.util.List;
//
//public class MarksPanel extends JPanel {
//    private JTable table;
//    private DefaultTableModel model;
//    private MarksDAO dao = new MarksDAO();
//
//    public MarksPanel() {
//        setLayout(new BorderLayout());
//        model = new DefaultTableModel();
//        table = new JTable(model);
//        JScrollPane scroll = new JScrollPane(table);
//        add(scroll, BorderLayout.CENTER);
//
//        JButton refresh = new JButton("Refresh");
//        refresh.addActionListener(e -> loadData());
//        JPanel top = new JPanel();
//        top.add(refresh);
//        add(top, BorderLayout.NORTH);
//
//        // Define table columns
//        model.setColumnIdentifiers(new Object[]{"regno", "subject_id", "CT1_marks", "CT2_marks"});
//        loadData();
//    }
//
//    private void loadData() {
//        try {
//            List<Marks> list = dao.getAll();
//            model.setRowCount(0);
//            for (Marks obj : list) {
//                model.addRow(new Object[]{obj.getRegno(), obj.getSubject_id(), obj.getCT1_marks(), obj.getCT2_marks()});
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//}
package com.aums.gui;

import com.aums.dao.MarksDAO;
import com.aums.models.Marks;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class MarksPanel extends JPanel {
    private final JTable table;
    private final DefaultTableModel model;
    private final MarksDAO dao = new MarksDAO();

    public MarksPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel();
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Refresh button
        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> loadData());
        JPanel top = new JPanel();
        top.add(refresh);
        add(top, BorderLayout.NORTH);

        // Define table columns
        model.setColumnIdentifiers(new Object[]{"regno", "subject_id", "CT1_marks", "CT2_marks"});
        loadData();
    }

    private void loadData() {
        try {
            List<Marks> list = dao.getAll();   // uses getAll() from MarksDAO
            model.setRowCount(0);
            for (Marks obj : list) {
                model.addRow(new Object[]{
                    obj.getRegno(),
                    obj.getSubject_id(),
                    obj.getCT1_marks(),
                    obj.getCT2_marks()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
