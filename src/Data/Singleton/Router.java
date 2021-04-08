package Data.Singleton;

import Constants.Routes;
import Data.Observer.JFrame.JFrameManager;
import Frontend.Screens.FindLessonBy.FindLessonBy;
import Frontend.Screens.UserTypeSelect.UserTypeSelect;
import Frontend.Screens.UserTypeSelect.UTS;
import Frontend.Screens.UserSelect.UserSelect;

import javax.swing.*;
import java.util.Stack;

public class Router {

    private static javax.swing.JFrame appContainer;
    private static String currentRoute;
    private static Stack<String> history = new Stack<>();

    private static Router uniqueInstance;

    private Router(){};

    public static Router getInstance(){
        if(uniqueInstance == null){
            Router router = new Router();

            JFrameManager app = Data.Singleton.JFrame.getInstance();
            appContainer = app.getJFrame();

            currentRoute = Routes.LOGIN;
            history.push(Routes.LOGIN);

            uniqueInstance = router;
        }
        return uniqueInstance;
    }

    public void paintScreen(){
        JComponent content = null;

        switch (currentRoute){
            case Routes.LOGIN:
                UserTypeSelect userTypeSelect = UTS.getInstance();
                content = userTypeSelect.component();
                break;
            case Routes.USER_SELECT:
                UserSelect userSelect = new UserSelect();
                content = userSelect.component();
                break;
            case Routes.FIND_LESSON_BY_SELECT:
                FindLessonBy findLessonBy = new FindLessonBy();
                content = findLessonBy.component();
        }
        appContainer.setContentPane(content);
        appContainer.revalidate();
    }

    public void setRoute(String route){
        currentRoute = route;
        paintScreen();

        history.push(route);
    }

    public void goBack() {
        history.pop();

        currentRoute = history.peek();
        paintScreen();
    }
}
