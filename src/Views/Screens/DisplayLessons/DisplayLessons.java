package Views.Screens.DisplayLessons;

import Controllers.SelectLesson;
import Data.Observer.Lesson.LessonManager;
import Data.Singleton.Lessons;
import Views.Router.RouterHooks;
import Views.Screens.MainLayout.MainLayout;
import Views.SharedComponents.Header;

import javax.swing.*;

public class DisplayLessons extends RouterHooks {

    private MainLayout container;

    public DisplayLessons(){
        LessonManager lessons = Lessons.getInstance();
        System.out.println(lessons.getLessonsToDisplay());

        this.container = new MainLayout(
                3,
                lessons.getLessonsToDisplay(),
                new Header(true, "Which lesson interests you ?"),
                new SelectLesson(),
                20, 20);

    }

    public JComponent component() {
        return container.component();
    }
}
