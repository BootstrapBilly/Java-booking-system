package Frontend.Handlers;

import Backend.User.User;
import Data.Observer.Session.SessionManager;
import Data.Singleton.Router;
import Data.Singleton.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PortalNavigationHandler implements ActionListener {
    public PortalNavigationHandler() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        String userType = ((JButton) e.getSource()).getName();
//        System.out.println(userType);

        SessionManager session = Session.getInstance();

        User user = new User("1", "billy", true, false);

        session.login(user);


        Router appRouter = Router.getInstance();
        appRouter.calculateRoute();
    }

}