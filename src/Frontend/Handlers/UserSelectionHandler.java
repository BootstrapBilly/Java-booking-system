package Frontend.Handlers;

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

public class UserSelectionHandler implements ActionListener {
    public UserSelectionHandler() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        // singletons
        UsersManager users = Users.getManager();
        SessionManager session = Session.getInstance();
        Router router = Router.getInstance();

        String userID = ((JButton) e.getSource()).getName(); // get the id from the user to login

        User user = users.getUserById(userID); // get the full user

        session.login(user); // log them in

        router.setRoute(Routes.FIND_LESSON_BY_SELECT);
    }

}
