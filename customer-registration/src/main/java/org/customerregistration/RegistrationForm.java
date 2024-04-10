package org.customerregistration;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RegistrationForm extends JFrame implements ActionListener {
    private JTextField regNoField, nameField, addressField, creditLimitField, balanceField, regDateField, idField;
    private JButton btnSave, btnList, btnClear, btnLoad;
    private JTextArea outputArea;
    private ArrayList<String> registrationList;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        JLabel lblRegNo = new JLabel("Registration No:");
        JLabel lblName = new JLabel("Name:");
        JLabel lblAddress = new JLabel("Address:");
        JLabel lblCreditLimit = new JLabel("Credit Limit:");
        JLabel lblBalance = new JLabel("Balance:");
        JLabel lblRegDate = new JLabel("Registration Date:");

        regNoField = new JTextField(20);
        nameField = new JTextField(20);
        addressField = new JTextField(20);
        creditLimitField = new JTextField(20);
        balanceField = new JTextField(20);
        regDateField = new JTextField(20);
        idField = new JTextField(20);
        regDateField.setText(getCurrentDate());
        regDateField.setEditable(false);

        btnSave = new JButton("Save");
        btnList = new JButton("List");
        btnClear = new JButton("Clear");
        btnLoad = new JButton("Load");

        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);


        JPanel btnPanel = new JPanel();
        btnPanel.add(btnSave);
        btnPanel.add(btnList);
        btnPanel.add(btnClear);
        btnPanel.add(btnLoad);
//        btnPanel.add(idField);

        // Add components to the frame
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.setBorder(new EmptyBorder(20, 20, 10, 20));
        panel.add(lblRegNo);
        panel.add(regNoField);
        panel.add(lblName);
        panel.add(nameField);
        panel.add(lblAddress);
        panel.add(addressField);
        panel.add(lblCreditLimit);
        panel.add(creditLimitField);
        panel.add(lblBalance);
        panel.add(balanceField);
        panel.add(lblRegDate);
        panel.add(regDateField);
        panel.add(btnPanel, BorderLayout.SOUTH);
        panel.add(idField);

        JPanel outputPanel = new JPanel();
        outputPanel.add(scrollPane);

        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.NORTH);
//        contentPane.add(btnPanel, BorderLayout.CENTER);
        contentPane.add(outputPanel, BorderLayout.SOUTH);

        // Add action listeners
        btnSave.addActionListener(this);
        btnList.addActionListener(this);
        btnClear.addActionListener(this);

        registrationList = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            saveRegistration();
        } else if (e.getSource() == btnList) {
            listRegistrations();
        } else if (e.getSource() == btnClear) {
            clearForm();
        }
    }

    private void saveRegistration() {
        String registration = "Registration No: " + regNoField.getText() +
                ", Name: " + nameField.getText() +
                ", Address: " + addressField.getText() +
                ", Credit Limit: " + creditLimitField.getText() +
                ", Balance: " + balanceField.getText() +
                ", Registration Date: " + regDateField.getText();

        registrationList.add(registration);
        outputArea.append("Registration saved.\n");
        clearForm();

        var factory = new SessionFactory();

        factory.setUp();
        factory.getSessionFactory().inTransaction(session -> {
            session.persist(new Customer(this.regNoField.getText(), this.nameField.getText(), this.addressField.getText(), Integer.getInteger(this.creditLimitField.getText()), Long.getLong(this.balanceField.getText()), new Date()));
        });
    }

    private void listRegistrations() {
        outputArea.append("List of Registrations:\n");
        for (String registration : registrationList) {
            outputArea.append(registration + "\n");
        }
    }

    private void clearForm() {
        regNoField.setText("");
        nameField.setText("");
        addressField.setText("");
        creditLimitField.setText("");
        balanceField.setText("");
        regDateField.setText(getCurrentDate());
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }
}
