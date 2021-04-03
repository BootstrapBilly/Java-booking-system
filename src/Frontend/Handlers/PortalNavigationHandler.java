package Frontend.Handlers;

import Data.Observer.SessionObserver.SessionManager;
import Data.Singleton.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PortalNavigationHandler implements ActionListener {
    public PortalNavigationHandler() {
        super ();
    }

    // this method provides the functionality when the button is clicked
    public void actionPerformed(ActionEvent e) {
        String userType = ((JButton) e.getSource()).getName();
        System.out.println(userType);

        SessionManager session = Session.getInstance();

        System.out.println("event");

        System.out.println(session.getSession());
    }

}