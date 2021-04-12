package Controllers;

import Models.User.User;
import Constants.Routes;
import Data.Observer.Session.SessionManager;
import Data.Observer.Users.UsersManager;
import Data.Singleton.Session;
import Data.Singleton.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectUser extends EventHandler implements ActionListener {
    private UsersManager users = Users.getManager();
    private SessionManager session = Session.getInstance();

    private String userID;
    private User user;

    public SelectUser() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        userID = ((JButton) e.getSource()).getName(); // get the id from the user to login

        handleNavigation();
    }

    @Override
    public void setupRequiredData(){
        user = users.getUserById(userID);
    }

    @Override
    public void updateDataStore(){
        session.login(user); // log them in
    }

    @Override
    public String handleNextRoute(){
        return Routes.FIND_LESSON_BY_SELECT;
    }

}
