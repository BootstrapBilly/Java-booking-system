package Frontend;

import Data.Observer.JFrame.JFrameManager;
import Data.Singleton.Router;
import Data.InjectTestData.GenerateUsers;
import Data.Singleton.Users;

import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        super("Booking system");

        // configure the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // store it in a singleton so the router can manipulate it
        JFrameManager app = Data.Singleton.JFrame.getInstance();
        app.setJframe(this);

        // setup the router and paint the first screen
        Router appRouter = Router.getInstance();
        appRouter.paintScreen();

        // setup the users data management system
        Users.init();
        GenerateUsers.all(); // generate some test users

    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
    }
}
