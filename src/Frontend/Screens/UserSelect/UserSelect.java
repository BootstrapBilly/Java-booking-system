package Frontend.Screens.UserSelect;

import Backend.User.User;
import Data.Observer.Users.UsersObserver;
import Data.Singleton.Users;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class UserSelect {

    private JPanel container;
    private ArrayList<User> users;

    static GridBagConstraints gbc = new GridBagConstraints();

    public UserSelect() {
        container = new JPanel();
        container.setLayout(new GridBagLayout());

        // get the users from the users data store
        UsersObserver usersObserver = Users.getObserver();
        this.users = usersObserver.getUsers(); // store them in the users variable

        addUsers();
        styleContainer();
    }

    public void addUsers(){
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridy = 0;

        Iterator<User> usersIterator = users.iterator();
        while(usersIterator.hasNext()){
            container.add(new JLabel(usersIterator.next().getName()));
        }

    }

    public void styleContainer(){
        container.setBackground(Color.cyan);
    }

    public JPanel component() {
        return container;
    }
}
