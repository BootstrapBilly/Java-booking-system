package Controllers;

import Constants.Routes;
import Constants.UserTypes;
import Data.Managers.Session.Session;
import Data.Managers.Session.SessionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends EventHandler implements ActionListener {

    private SessionManager session = Session.getInstance();
    private String userType;

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