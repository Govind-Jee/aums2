//package com.aums.gui;
//
//import com.aums.dao.MarksDAO;
//import com.aums.models.Marks;
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.sql.SQLException;
//import java.util.List;
//
//public class ViewMarksPanel extends JPanel {
//    private JTable table;
//    private DefaultTableModel model;
//    private MarksDAO dao = new MarksDAO();
//    private String section;
//
//    public ViewMarksPanel(String section) {
//        this.section = section;
//        setLayout(new BorderLayout());
//        model = new DefaultTableModel();
//        table = new JTable(model);
//        table.setEnabled(false);
//        add(new JScrollPane(table), BorderLayout.CENTER);
//        model.setColumnIdentifiers(new Object[]{ "regno", "subject_id", "CT1_marks", "CT2_marks" });
//        loadData();
//    }
//
//    private void loadData() {
//        try {
//            List<Marks> list = dao.getBySection(section);
//            model.setRowCount(0);
//            for (Marks m: list) {
//                model.addRow(new Object[]{m.getRegno(), m.getSubject_id(), m.getCT1_marks(), m.getCT2_marks()});
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

public class ViewMarksPanel extends JPanel {
    private final JTable table;
    private final DefaultTableModel model;
    private final MarksDAO dao = new MarksDAO();
    private final String section;

    public ViewMarksPanel(String section) {
        this.section = section;
        setLayout(new BorderLayout());

        model = new DefaultTableModel();
        table = new JTable(model);
        table.setEnabled(false); // read‐only
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Define table columns
        model.setColumnIdentifiers(new Object[]{"regno", "subject_id", "CT1_marks", "CT2_marks"});
        loadData();
    }

    private void loadData() {
        try {
            List<Marks> list = dao.getBySection(section);
            model.setRowCount(0);
            for (Marks m : list) {
                model.addRow(new Object[]{
                    m.getRegno(),
                    m.getSubject_id(),
                    m.getCT1_marks(),
                    m.getCT2_marks()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
