package com.aums.gui;

import com.aums.dao.LoginDAO;
import com.aums.models.Login;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginDialog extends JDialog {
    private JTextField userField = new JTextField(10);
    private JPasswordField passField = new JPasswordField(10);
    private Login loginUser = null;

    public LoginDialog(Frame owner) {
        super(owner, "Login", true);
        setLayout(new GridLayout(3,2));
        add(new JLabel("User ID:")); add(userField);
        add(new JLabel("Password:")); add(passField);
        JButton ok = new JButton("OK");
        ok.addActionListener(e -> authenticate());
        add(new JLabel()); add(ok);
        pack();
        setLocationRelativeTo(owner);
    }

    private void authenticate() {
        try {
            LoginDAO dao = new LoginDAO();
            //String passHash = passField.getText(); // assume hash
            char[] passwordChars = passField.getPassword();
            String passHash = new String(passwordChars);
            Login user = dao.authenticate(userField.getText(), passHash);
            if (user != null) {
                loginUser = user;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Login getLoginUser() {
        return loginUser;
    }
}
