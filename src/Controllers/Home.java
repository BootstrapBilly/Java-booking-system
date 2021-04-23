package Controllers;

import Constants.Routes;
import Constants.UserTypes;
import Data.Managers.Session.Session;
import Data.Managers.Session.SessionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends EventHandler implements ActionListener {

    // state managers
    private SessionManager session = Session.getInstance();

    // instance variables
    private String userType; // admin, parent or student

    public Home() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }

    @Override
    public void setupRequiredData() {
        userType = session.getUserType();
    }

    @Override
    public String handleNextRoute() {

        /* this event handler is attached to the home button which
         returns the user to the root page, which is different for admins */

        String route = "";

        switch (userType){
            case UserTypes.STUDENT:
            case UserTypes.PARENT:
                route = Routes.FIND_EVENT_BY_SELECT;
                break;
            case UserTypes.ADMIN:
                route = Routes.ADMIN_FUNCTION_SELECT;
                break;


        }
        return route;
    }
}