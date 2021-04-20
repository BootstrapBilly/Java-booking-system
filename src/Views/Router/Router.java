package Views.Router;

import Constants.Routes;
import Data.Managers.JFrame.JFrameManager;
import Views.Main;
import Views.Screens.*;
import Views.Screens.DisplayReport.DisplayReport;
import Views.Screens.UserTypeSelect.UserTypeSelect;
import Views.Screens.UserTypeSelect.UTS;

import javax.swing.*;
import java.util.Stack;

public class Router {

    private static Main appContainer;
    private static String currentRoute;
    private static Stack<String> history = new Stack<>();

    private static Router uniqueInstance;

    private Router(){};

    public static Router getInstance(){
        if(uniqueInstance == null){
            Router router = new Router();

            JFrameManager app = Data.Managers.JFrame.JFrame.getInstance();
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
                break;
            case Routes.DISPLAY_COACHES:
                DisplayCoaches displayCoaches = new DisplayCoaches();
                content = displayCoaches.component();
                break;
            case Routes.DISPLAY_LESSONS:
                DisplayLessons displayLessons = new DisplayLessons();
                content = displayLessons.component();
                break;
                case Routes.DISPLAY_ACTIVITY_TYPES:
                DisplayActivityTypes displayActivityTypes = new DisplayActivityTypes();
                content = displayActivityTypes.component();
                break;
                case Routes.DISPLAY_APPOINTMENTS:
                DisplayAppointments displayAppointments = new DisplayAppointments();
                content = displayAppointments.component();
                break;
            case Routes.ADMIN_FUNCTION_SELECT:
                AdminFunctionSelect adminFunctionSelect = new AdminFunctionSelect();
                content = adminFunctionSelect.component();
                break;
            case Routes.REPORT_TYPE_SELECT:
                ReportTypeSelect reportTypeSelect = new ReportTypeSelect();
                content = reportTypeSelect.component();
                break;
            case Routes.DISPLAY_REPORT:
                DisplayReport displayReport = new DisplayReport();
                content = displayReport.component();
                break;
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
