package Frontend.Handlers;

import static Constants.UserTypes.PARENT;

import Backend.User.User;
import Constants.Routes;
import Data.Observer.Session.SessionManager;
import Data.Observer.Users.UsersManager;
import Data.Singleton.Router;
import Data.Singleton.Session;
import Data.Singleton.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserTypeSelectionHandler implements ActionListener {
    public UserTypeSelectionHandler() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        String userType = ((JButton) e.getSource()).getName();

        SessionManager session = Session.getInstance();
        Router appRouter = Router.getInstance();

        session.setUserType(userType);

        if(userType == PARENT){
            appRouter.setRoute(Routes.FIND_LESSON_BY_SELECT);
            return;
        }

        appRouter.setRoute(Routes.USER_SELECT);
    }

}