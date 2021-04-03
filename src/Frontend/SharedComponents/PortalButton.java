package Frontend.SharedComponents;

import javax.swing.*;
import java.awt.*;
import Frontend.Handlers.PortalNavigationHandler;

public class PortalButton {

    private JButton container;

    public PortalButton(String text) {
        container = new JButton();
        container.setLayout(new GridBagLayout());
        container.addActionListener(new PortalNavigationHandler());
        container.setName(text);

        JLabel title = new JLabel(text);
        container.add(title);
    }

    public JButton component(){
        return container;
    }
}
