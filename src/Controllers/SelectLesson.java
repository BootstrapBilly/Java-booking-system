package Controllers;

import Data.Observer.Lesson.LessonManager;
import Data.Singleton.Lessons;
import Views.Router.Router;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectLesson implements ActionListener {
    public SelectLesson() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        // singletons
        LessonManager lessons = Lessons.getInstance();

        lessons.addLessonToDisplay();

        Router router = Router.getInstance();
        router.paintScreen();


    }

}
