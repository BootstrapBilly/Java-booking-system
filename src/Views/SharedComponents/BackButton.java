package Views.SharedComponents;

import Controllers.BackwardsNavigation;

import javax.swing.*;
import java.awt.*;

public class BackButton {

    private JButton container;

    public BackButton() {
        container = new JButton("Go Back");
        container.setLayout(new GridBagLayout());
        container.addActionListener(new BackwardsNavigation());

    }

    public JButton component() { return container; }

}