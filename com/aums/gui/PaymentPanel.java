package com.aums.gui;

import com.aums.dao.PaymentDAO;
import com.aums.models.Payment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class PaymentPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private PaymentDAO dao = new PaymentDAO();

    public PaymentPanel() {
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
        model.setColumnIdentifiers(new Object[]{"payment_id", "regno", "course_id", "course_fee", "hostel_id", "hostel_fee", "payment_date"});
        loadData();
    }

    private void loadData() {
        try {
            List<Payment> list = dao.getAll();
            model.setRowCount(0);
            for (Payment obj : list) {
                model.addRow(new Object[]{obj.getPayment_id(), obj.getRegno(), obj.getCourse_id(), obj.getCourse_fee(), obj.getHostel_id(), obj.getHostel_fee(), obj.getPayment_date()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
