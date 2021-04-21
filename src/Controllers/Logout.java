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


    @Override
    public String handleNextRoute() {
        return Routes.LOGIN;
    }
}