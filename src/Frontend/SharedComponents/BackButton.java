package Frontend.SharedComponents;

import Frontend.Handlers.BackNavigationHandler;

import javax.swing.*;
import java.awt.*;

public class BackButton {

    private JButton container;

    public BackButton() {
        container = new JButton("Back");
        container.setLayout(new GridBagLayout());
        container.addActionListener(new BackNavigationHandler());

    }

    public JButton component() { return container; }

}