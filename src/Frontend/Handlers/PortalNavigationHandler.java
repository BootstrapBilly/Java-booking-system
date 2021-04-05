package Frontend.Handlers;

import Constants.Routes;
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

        SessionManager session = Session.getInstance();

        session.setUserType(userType);

        Router appRouter = Router.getInstance();
        appRouter.setRoute(Routes.USER_SELECT);
    }

}