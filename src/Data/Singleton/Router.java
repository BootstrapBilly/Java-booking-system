package Data.Singleton;

import Data.Observer.JFrame.JFrameManager;
import Data.Observer.Session.SessionManager;
import Frontend.Login.LoginScreen;

import javax.swing.*;

public class Router {

    private static javax.swing.JFrame appContainer;

    private static Router uniqueInstance;

    private Router(){};

    public static Router getInstance(){
        if(uniqueInstance == null){
            Router router = new Router();

            JFrameManager app = Data.Singleton.JFrame.getInstance();
            appContainer = app.getJFrame();

            uniqueInstance = router;
        }
        return uniqueInstance;
    }

    public void calculateRoute(){
        SessionManager session = Session.getInstance();

        if(session.getSession() == null){
            LoginScreen loginScreen = new LoginScreen();
            appContainer.add(loginScreen.component());
        } else {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("hi");

            panel.add(label);

            appContainer.setContentPane(panel);
            appContainer.revalidate();

        }
    }
}
