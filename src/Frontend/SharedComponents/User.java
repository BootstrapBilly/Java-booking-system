package Frontend.SharedComponents;

import Frontend.Handlers.PortalNavigationHandler;
import Frontend.Handlers.UserSelectionHandler;

import javax.swing.*;
import java.awt.*;

public class User {

    private JButton container;

    public User(String text) {
        container = new JButton();
        container.setLayout(new GridBagLayout());
        container.addActionListener(new UserSelectionHandler());
        container.setName(text);

        JLabel title = new JLabel(text);
        container.add(title);
    }

    public JButton component() { return container; }

}