package Frontend;

import Backend.User.User;
import Data.Observer.SessionObserver.SessionManager;
import Data.Singleton.Session;
import Frontend.Login.LoginScreen;

import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        super("Booking system");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LoginScreen loginScreen = new LoginScreen();
        add(loginScreen.component());

        setExtendedState(JFrame.MAXIMIZED_BOTH); //full screen j frame

        SessionManager session = Session.getInstance();

        User user = new User("1", "billy", true, false);
        System.out.println(session.getSession());

        session.login(user);

        System.out.println("Main");
        System.out.println(session.getSession());



    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
    }
}
