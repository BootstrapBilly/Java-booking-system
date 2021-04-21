package Views.Screens;

import Constants.CardTypes;
import Controllers.SelectLesson;
import Data.Managers.Lessons.LessonsManager;
import Data.Managers.Lessons.Lessons;
import Views.Screens.Layouts.MainLayout;
import Views.SharedComponents.Header;

import javax.swing.*;

public class DisplayLessons {

    private MainLayout container;

    public DisplayLessons(){
        LessonsManager lessons = Lessons.getInstance();

        this.container = new MainLayout(
                3,
                lessons.getLessonsToDisplay(),
                CardTypes.LESSON,
                new Header(true, "Which lesson interests you ?"),
                new SelectLesson(),
                20, 20, true);

    }

    public JComponent component() {
        return container.component();
    }

}
