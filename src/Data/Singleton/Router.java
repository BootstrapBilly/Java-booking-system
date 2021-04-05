package Data.Singleton;

import Constants.Routes;
import Data.Observer.JFrame.JFrameManager;
import Frontend.Screens.Login.LoginScreen;
import Frontend.Screens.UserSelect.UserSelect;

import javax.swing.*;

public class Router {

    private static javax.swing.JFrame appContainer;
    private static String currentRoute;

    private static Router uniqueInstance;

    private Router(){};

    public static Router getInstance(){
        if(uniqueInstance == null){
            Router router = new Router();

            JFrameManager app = Data.Singleton.JFrame.getInstance();
            appContainer = app.getJFrame();

            currentRoute = Routes.LOGIN;

            uniqueInstance = router;
        }
        return uniqueInstance;
    }

    public void paintScreen(){
        JComponent content = null;

        switch (currentRoute){
            case Routes.LOGIN:
                LoginScreen loginScreen = new LoginScreen();
                content = loginScreen.component();
                break;
            case Routes.USER_SELECT:
                UserSelect userSelect = new UserSelect();
                content = userSelect.component();
                break;
        }
        appContainer.setContentPane(content);
        appContainer.revalidate();
    }

    public void setRoute(String route){
        currentRoute = route;
        paintScreen();
    }
}
