package com.aums.gui;

import com.aums.models.Login;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainFrame extends JFrame {
    private CardLayout cards = new CardLayout();
    private JPanel container = new JPanel(cards);
    private Login user;

    public MainFrame(Login user) {
        this.user = user;
        setTitle("AUMS Management - " + user.getRole());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);

        // Add panels based on role
        if ("admin".equals(user.getRole())) {
            addAdminPanels();
        } else {
            if (user.getFaSection() == null) {
                // regular faculty: marks entry
                container.add(new MarksPanel(), "Marks");
            } else {
                // faculty advisor: view marks
                container.add(new ViewMarksPanel(user.getFaSection()), "ViewMarks");
            }
        }

        setJMenuBar(createMenuBar());
        add(container);
    }

    private void addAdminPanels() {
        container.add(new DepartmentPanel(), "Department");
        container.add(new CoursePanel(), "Course");
        container.add(new FacultyPanel(), "Faculty");
        // ... add all existing panels ...
        container.add(new MarksPanel(), "Marks");
        container.add(new AttendanceStudentPanel(), "AttendanceStudent");
        container.add(new AttendanceTeacherPanel(), "AttendanceTeacher");
        container.add(new LibraryPanel(), "Library");
        container.add(new StudentLibraryPanel(), "StudentLibrary");
        container.add(new HostelPanel(), "Hostel");
        container.add(new HostelWardenPhonePanel(), "HostelWardenPhone");
        container.add(new ClubDetailsPanel(), "ClubDetails");
        container.add(new StudentClubPanel(), "StudentClub");
        container.add(new ExamPanel(), "Exam");
        container.add(new PaymentPanel(), "Payment");
        container.add(new NoticeBoardPanel(), "NoticeBoard");
        container.add(new EventsPanel(), "Events");
    }

    private JMenuBar createMenuBar() {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        if ("admin".equals(user.getRole())) {
            for (Component comp : container.getComponents()) {
                String name = container.getComponentZOrder(comp) + "";
                JMenuItem item = new JMenuItem(comp.getClass().getSimpleName().replace("Panel",""));
                item.addActionListener(e -> cards.show(container, item.getText()));
                menu.add(item);
            }
        } else {
            JMenuItem item = new JMenuItem(user.getFaSection() == null ? "Marks" : "ViewMarks");
            item.addActionListener(e -> cards.show(container, item.getText()));
            menu.add(item);
        }
        bar.add(menu);
        return bar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginDialog dlg = new LoginDialog(null);
            dlg.setVisible(true);
            Login user = dlg.getLoginUser();
            if (user != null) {
                new MainFrame(user).setVisible(true);
            } else {
                System.exit(0);
            }
        });
    }
}
