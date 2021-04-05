package Frontend;

import Backend.User.User;
import Data.Observer.JFrame.JFrameManager;
import Data.Observer.Session.SessionManager;
import Data.Singleton.Router;
import Data.Singleton.Session;
import Frontend.Login.LoginScreen;

import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        super("Booking system");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); //full screen j frame
        JFrameManager app = Data.Singleton.JFrame.getInstance();
        app.setJframe(this);

        Router appRouter = Router.getInstance();
        appRouter.calculateRoute();

    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
    }
}
