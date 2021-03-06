package Views.SharedComponents;

import Controllers.SelectUser;

import javax.swing.*;
import java.awt.*;

public class User {

    private JButton container;

    public User(String ID, String text) {
        container = new JButton();
        container.setLayout(new GridBagLayout());
        container.addActionListener(new SelectUser());
        container.setName(ID);

        JLabel title = new JLabel(text);
        container.add(title);
    }

    public JButton component() { return container; }

}