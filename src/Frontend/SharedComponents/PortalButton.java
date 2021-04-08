package Frontend.SharedComponents;

import javax.swing.*;
import java.awt.*;
import Frontend.Handlers.UserTypeSelectionHandler;

public class PortalButton {

    private JButton container;

    public PortalButton(String text) {
        container = new JButton();
        container.setLayout(new GridBagLayout());
        container.addActionListener(new UserTypeSelectionHandler());
        container.setName(text);

        JLabel title = new JLabel(text);
        container.add(title);
    }

    public JButton component(){
        return container;
    }
}
