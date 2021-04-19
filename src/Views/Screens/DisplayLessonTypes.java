package Views.Screens;

import Constants.CardTypes;
import Controllers.SelectLessonType;
import Data.Managers.Lessons.LessonManager;
import Data.Managers.Lessons.Lessons;
import Views.SharedComponents.Header;
import javax.swing.*;


public class DisplayLessonTypes {

    private MainLayout container;

    public DisplayLessonTypes(){

        LessonManager lessons = Lessons.getInstance();

        this.container = new MainLayout(
                3,
                lessons.getLessonTypes(),
                CardTypes.NAVIGATION,
                new Header(true, "Which type of activity ?"),
                new SelectLessonType(),
                20, 20, false);
    }

    public JComponent component() {
        return container.component();
    }
}
