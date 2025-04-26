package com.aums.gui;

import com.aums.dao.LibraryDAO;
import com.aums.models.Library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class LibraryPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private LibraryDAO dao = new LibraryDAO();

    public LibraryPanel() {
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
        model.setColumnIdentifiers(new Object[]{"book_id", "title", "author"});
        loadData();
    }

    private void loadData() {
        try {
            List<Library> list = dao.getAll();
            model.setRowCount(0);
            for (Library obj : list) {
                model.addRow(new Object[]{obj.getBook_id(), obj.getTitle(), obj.getAuthor()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
