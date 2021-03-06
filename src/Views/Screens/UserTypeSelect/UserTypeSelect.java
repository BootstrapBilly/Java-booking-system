package Views.Screens.UserTypeSelect;

import Views.SharedComponents.PortalButton;
import static Constants.UserTypes.ADMIN;
import static Constants.UserTypes.STUDENT;
import static Constants.UserTypes.PARENT;

import javax.swing.*;
import java.awt.*;

public class UserTypeSelect {

    private JPanel container;

    static GridBagConstraints gbc = new GridBagConstraints();

    static JPanel leftCol = new JPanel();
    static JPanel midCol = new JPanel();
    static JPanel rightCol = new JPanel();

    public UserTypeSelect() {
        container = new JPanel();
        container.setLayout(new GridBagLayout());

        addColumns();
    }

    public void addColumns(){
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridy = 0;

        addLeftCol();
        addMidCol();
        addRightCol();
    }

    public void addLeftCol(){
        leftCol.setLayout(new GridBagLayout());

        PortalButton student = new PortalButton(STUDENT);
        leftCol.add(student.component());

        gbc.gridx = 1;
        container.add(leftCol, gbc);
    }

    public void addMidCol(){
        midCol.setLayout(new GridBagLayout());

        PortalButton parent = new PortalButton(PARENT);
        midCol.add(parent.component());

        gbc.gridx = 2;
        container.add(midCol, gbc);
    }

    public void addRightCol(){
        rightCol.setLayout(new GridBagLayout());

        PortalButton admin = new PortalButton(ADMIN);

        rightCol.add(admin.component());

        gbc.gridx = 3;
        container.add(rightCol, gbc);
    }

    public JPanel component() {
        return container;
    }

    public void destroy(){
        container.removeAll();
    }
}
