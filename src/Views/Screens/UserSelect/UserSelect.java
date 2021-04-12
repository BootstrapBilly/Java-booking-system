package Views.Screens.UserSelect;
import static Constants.UserTypes.ADMIN;
import static Constants.UserTypes.STUDENT;
import Models.User.User;
import Data.Observer.Session.SessionManager;
import Data.Observer.Users.UsersObserver;
import Data.Singleton.Session;
import Data.Singleton.Users;
import Views.SharedComponents.Header;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class UserSelect {

    private JPanel container;
    private JPanel userDisplayContainer = new JPanel();

    private ArrayList<User> users;

    static GridBagConstraints gbc = new GridBagConstraints();

    public UserSelect() {
        container = new JPanel();
        container.setLayout(new GridBagLayout());

        // get the users from the users data store
        UsersObserver usersObserver = Users.getObserver();
        this.users = usersObserver.getUsers(); // store them in the users variable

        setupMainLayout();
        styleContainer();
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

        addUsers();
    }

    public void addHeader(){
        Header header = new Header(true, "Who are you ?");

        container.add(header.component(), gbc);
    }

    public void addUsers(){
        SessionManager session = Session.getInstance();
        String userType = session.getUserType();

        Iterator<User> usersIterator = users.iterator();
        while(usersIterator.hasNext()){

            Views.SharedComponents.User user;
            User next = usersIterator.next();

            switch(userType){
                case ADMIN:
                    if(next.isAdmin()){
                        user = new Views.SharedComponents.User(next.getID(), next.getName());
                        userDisplayContainer.add(user.component());
                    };
                    break;
                case STUDENT:
                    if(next.isStudent()){
                        user = new Views.SharedComponents.User(next.getID(), next.getName());
                        userDisplayContainer.add(user.component());
                    }
            }
        }

        container.add(userDisplayContainer, gbc);
    }

    public void styleContainer(){
        container.setBackground(Color.cyan);
        userDisplayContainer.setBackground(Color.pink);
    }

    public JPanel component() {
        return container;
    }
}
