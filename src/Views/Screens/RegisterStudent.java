package Views.Screens;

import Data.Managers.Students.Students;
import Data.Managers.Students.StudentsManager;
import Views.SharedComponents.Header;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RegisterStudent {

    private JPanel container;
    private JPanel inputsContainer = new JPanel(new GridBagLayout());

    private String[] labels = {"Name", "address", "phone"};

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

        addInputContainer();

    }

    public void addHeader(){
        Header header = new Header(true, "Register new student");

        container.add(header.component(), gbc);
    }

    public void addInputContainer(){
        addInputRows(labels);
        this.container.add(inputsContainer, gbc);
    }

    public void addInputRows(String[] labels){
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.weightx = 1;

        int rowIndex = 0;

        for(String row : labels){
            gbc.gridy = rowIndex;
            gbc.weighty =
                    rowIndex == 0 ?
                            0
                            :
                            labels.length/rowIndex;;

            JPanel inputsContainerRow = new JPanel(new GridBagLayout());

            if(rowIndex == 1){

                int currentInputID = 0;

                for(String label : labels){
                    JLabel labelText = new JLabel(label);
                    labelText.setBorder(new EmptyBorder(0,0,0,10));

                    JTextField input = new JTextField();
                    input.setColumns(25);

                    String id = String.valueOf(currentInputID);
                    input.setName(id);

                    input.addKeyListener(new KeyListener() {

                        public void keyTyped(KeyEvent e) {}
                        public void keyPressed(KeyEvent e) {}

                        @Override
                        public void keyReleased(KeyEvent e) {
                            StudentsManager students = Students.getInstance();
                            students.setNewStudentDetails(input.getName(), input.getText());
                        }
                    });

                    JLabel gap = new JLabel("");
                    gap.setBorder(new EmptyBorder(0,0,0,10));

                    inputsContainerRow.add(labelText);
                    inputsContainerRow.add(input);
                    inputsContainerRow.add(gap);

                    currentInputID += 1;

                }
            }

            if(rowIndex == labels.length - 2){
                JButton confirm = new JButton("Register");
                confirm.setBorder(new EmptyBorder(2,2,2,2));
                confirm.addActionListener(new Controllers.RegisterStudent());
                inputsContainerRow.add(confirm);
            }

            this.inputsContainer.add(inputsContainerRow, gbc);

            rowIndex += 1;
        }

    }

    public JPanel component() {
        return container;
    }
}
