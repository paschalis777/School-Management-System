package project2;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class school2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField firstNameField, lastNameField, dobField, genderField, addressField, gradeField;
    private JComboBox<String> courseComboBox;
    private JButton addButton, assignButton, viewButton, addGradeButton, deleteButton, viewCoursesButton, clearButton;
    private Connection connection;
    private GridBagConstraints constraints_1;
    private GridBagConstraints constraints_2;
    private GridBagConstraints constraints_3;
    private GridBagConstraints constraints_4;
    private GridBagConstraints constraints_5;
    private GridBagConstraints constraints_6;

    public school2() {
        courseComboBox = new JComboBox<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/school_db", "root", "");
            if (connection != null) {
                System.out.println("Η σύνδεση στη βάση δεδομένων ήταν επιτυχής!");
            } else {
                System.out.println("Η σύνδεση στη βάση δεδομένων απέτυχε.");
            }
            loadCourses();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        setTitle("School Management System");
        setSize(977, 1161);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_panel.rowHeights = new int[]{0, 0, 4, 41, 0, 41, 0, 41, 41, 36, 41, 41, 0, 33, 41, 0, 36, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWidths = new int[]{162, 16, 114, 0, 0, 0, 1, 275, 15};
        JPanel panel = new JPanel(gbl_panel);
        panel.setBackground(new Color(101, 177, 177));
        GridBagConstraints constraints;

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        constraints = new GridBagConstraints();
        constraints.gridwidth = 4;
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(firstNameLabel, constraints);

        firstNameField = new JTextField(20);
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(firstNameField, constraints);

        courseComboBox = new JComboBox<>();
        courseComboBox.setPreferredSize(new Dimension(200, 20));
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.gridx = 7;
        constraints.gridy = 6;
        panel.add(courseComboBox, constraints);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(lastNameLabel, constraints);

        lastNameField = new JTextField(20);
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(lastNameField, constraints);

        assignButton = new JButton("Assign Course");
        assignButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        constraints_2 = new GridBagConstraints();
        constraints_2.insets = new Insets(0, 0, 5, 5);
        constraints_2.gridx = 7;
        constraints_2.gridy = 7;
        constraints_2.anchor = GridBagConstraints.CENTER;
        panel.add(assignButton, constraints_2);

        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignCourse();
            }
        });

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(dobLabel, constraints);

        dobField = new JTextField(20);
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(dobField, constraints);

        addGradeButton = new JButton("Add Grade");
        addGradeButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        constraints_4 = new GridBagConstraints();
        constraints_4.insets = new Insets(0, 0, 5, 5);
        constraints_4.gridx = 7;
        constraints_4.gridy = 8;
        constraints_4.anchor = GridBagConstraints.CENTER;
        panel.add(addGradeButton, constraints_4);

        addGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGrade();
            }
        });

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(genderLabel, constraints);

        genderField = new JTextField(20);
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 9;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(genderField, constraints);

        gradeField = new JTextField(20);
        gradeField.setText("Add Grade");
        gradeField.setToolTipText("Add Grade");
        gradeField.setFont(new Font("Tahoma", Font.BOLD, 11));
        gradeField.setHorizontalAlignment(SwingConstants.CENTER);
        constraints = new GridBagConstraints();
        constraints.gridx = 7;
        constraints.gridy = 9;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(gradeField, constraints);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(addressLabel, constraints);

        addressField = new JTextField(20);
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 10;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(addressField, constraints);

        addButton = new JButton("Add Student");
        addButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        constraints_1 = new GridBagConstraints();
        constraints_1.insets = new Insets(0, 0, 5, 5);
        constraints_1.gridx = 2;
        constraints_1.gridy = 11;
        constraints_1.gridwidth = 2;
        panel.add(addButton, constraints_1);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        viewCoursesButton = new JButton("View Courses");
        viewCoursesButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        constraints_6 = new GridBagConstraints();
        constraints_6.insets = new Insets(0, 0, 5, 5);
        constraints_6.gridx = 2;
        constraints_6.gridy = 12;
        constraints_6.anchor = GridBagConstraints.CENTER;
        panel.add(viewCoursesButton, constraints_6);

        viewCoursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewCourses();
            }
        });

        getContentPane().add(panel);

        deleteButton = new JButton("Delete Student");
        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        constraints_5 = new GridBagConstraints();
        constraints_5.insets = new Insets(0, 0, 5, 5);
        constraints_5.gridx = 0;
        constraints_5.gridy = 13;
        constraints_5.anchor = GridBagConstraints.CENTER;
        panel.add(deleteButton, constraints_5);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        viewButton = new JButton("View Grades");
        viewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        constraints_3 = new GridBagConstraints();
        constraints_3.insets = new Insets(0, 0, 5, 5);
        constraints_3.gridx = 2;
        constraints_3.gridy = 13;
        constraints_3.anchor = GridBagConstraints.CENTER;
        panel.add(viewButton, constraints_3);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewGrades();
            }
        });

        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        constraints_5 = new GridBagConstraints();
        constraints_5.insets = new Insets(0, 0, 5, 5);
        constraints_5.gridx = 2;
        constraints_5.gridy = 14;
        constraints_5.anchor = GridBagConstraints.CENTER;
        panel.add(clearButton, constraints_5);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/school_db", "root", "");

            loadCourses();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

  
