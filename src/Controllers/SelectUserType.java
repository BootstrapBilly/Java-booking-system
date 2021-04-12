package Controllers;

import static Constants.UserTypes.PARENT;

import Constants.Routes;
import Data.Observer.Session.SessionManager;
import Data.Singleton.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectUserType extends EventHandler implements ActionListener {
    private String userType;
    private SessionManager session = Session.getInstance();

    public SelectUserType() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        userType = ((JButton) e.getSource()).getName();
        handleNavigation();
    }

    @Override
    public void updateDataStore(){
        session.setUserType(userType);
    }

    @Override
    public String handleNextRoute(){
        if(userType == PARENT){
            return Routes.FIND_LESSON_BY_SELECT;
        }
        return Routes.USER_SELECT;
    }

}