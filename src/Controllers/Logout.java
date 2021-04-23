package Controllers;

import Constants.Routes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logout extends EventHandler implements ActionListener {

    public Logout() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }

    // this event handler takes the user back to the login page where they can select parent, student or admin
    @Override
    public String handleNextRoute() {
        return Routes.LOGIN;
    }
}