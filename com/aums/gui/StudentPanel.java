package com.aums.gui;

import com.aums.dao.StudentDAO;
import com.aums.models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class StudentPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private StudentDAO dao = new StudentDAO();

    public StudentPanel() {
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
        model.setColumnIdentifiers(new Object[]{"regno", "full_name", "father_name", "mother_name", "dob", "srm_email", "gender", "aadhar", "class_x_percentage", "class_xii_percentage", "course_id", "department_id", "branch", "semester", "section_id", "address", "hostel_id", "room_no"});
        loadData();
    }

    private void loadData() {
        try {
            List<Student> list = dao.getAll();
            model.setRowCount(0);
            for (Student obj : list) {
                model.addRow(new Object[]{obj.getRegno(), obj.getFull_name(), obj.getFather_name(), obj.getMother_name(), obj.getDob(), obj.getSrm_email(), obj.getGender(), obj.getAadhar(), obj.getClass_x_percentage(), obj.getClass_xii_percentage(), obj.getCourse_id(), obj.getDepartment_id(), obj.getBranch(), obj.getSemester(), obj.getSection_id(), obj.getAddress(), obj.getHostel_id(), obj.getRoom_no()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
