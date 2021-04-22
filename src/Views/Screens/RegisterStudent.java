package Views.Screens;

import Data.Managers.Students.Students;
import Data.Managers.Students.StudentsManager;
import Views.SharedComponents.NavigationCard;
import Views.SharedComponents.Header;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RegisterStudent {

    private JPanel container;

    static GridBagConstraints gbc = new GridBagConstraints();

    public RegisterStudent() {
        container = new JPanel();
        container.setLayout(new GridBagLayout());

        setupMainLayout();
    }

    public void setupMainLayout(){
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.weighty = 0.05;
        gbc.weightx = 1;
        gbc.gridy = 0;

        addHeader();

        gbc.gridy = 1;
        gbc.weighty = 0.95;

        addInput();
    }

    public void addHeader(){
        Header header = new Header(true, "Register new student");

        container.add(header.component(), gbc);
    }

    public void addInput(){
        JPanel inputContainer = new JPanel(new GridBagLayout());

        JLabel label = new JLabel("Student name:");
        label.setBorder(new EmptyBorder(0,0,0,10));

        JTextField input = new JTextField();
        input.setColumns(25);

        input.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                StudentsManager students = Students.getInstance();
                students.setNewStudentName(input.getText());
            }
        });

        JLabel gap = new JLabel("");
        gap.setBorder(new EmptyBorder(0,0,0,10));

        JButton confirm = new JButton("Register");
        confirm.setBorder(new EmptyBorder(2,2,2,2));
        confirm.addActionListener(new Controllers.RegisterStudent());

        inputContainer.add(label);
        inputContainer.add(input);
        inputContainer.add(gap);
        inputContainer.add(confirm);

        container.add(inputContainer, gbc);
    }


    public JPanel component() {
        return container;
    }
}
