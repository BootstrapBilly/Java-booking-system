package Controllers;

import Constants.UserTypes;
import Data.Managers.Students.StudentsManager;
import Data.Managers.Students.Students;
import Constants.Routes;
import Data.Managers.Session.SessionManager;
import Data.Managers.Users.UsersManager;
import Data.Managers.Session.Session;
import Data.Managers.Users.Users;
import Models.Util.Entity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectUser extends EventHandler implements ActionListener {

    // state managers
    private UsersManager users = Users.getInstance();
    private SessionManager session = Session.getInstance();
    private StudentsManager students = Students.getInstance();

    // instance variables
    private String userID;
    private Entity user;

    public SelectUser() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        userID = ((JButton) e.getSource()).getName(); // get the id from the user to login

        handleEvent();
    }

    @Override
    public void setupRequiredData(){
        // if a student is logged in
        if(session.getUserType() == UserTypes.STUDENT){
            user = students.getStudentById(userID); // store the full student object as the logged in user
        }
        // otherwise its a parent or admin
        else {
            user = users.getUserById(userID); // store only the entity (ID and name) as the logged in user
        }
    }

    @Override
    public void updateDataStore(){
        session.login(user); // log them in
    }

    @Override
    public String handleNextRoute(){
        return Routes.FIND_EVENT_BY_SELECT;
    }

}
