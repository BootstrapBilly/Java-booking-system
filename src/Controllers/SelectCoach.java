package Controllers;

import Constants.Routes;
import Data.Observer.Lesson.LessonManager;
import Data.Singleton.Lessons;
import Models.Lesson.Lesson;
import Data.Observer.Coaches.CoachesManager;
import Data.Singleton.Coaches;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectCoach extends EventHandler implements ActionListener {
    private CoachesManager coaches = Coaches.getInstance();
    private LessonManager lessons = Lessons.getInstance();

    private String coachID;
    private Lesson[] lessonsToDisplay;

    public SelectCoach() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        coachID = ((JButton) e.getSource()).getName();

        handleNavigation();
    }

    @Override
    public void setupRequiredData() {
        lessonsToDisplay = coaches.getCoachById(coachID).getLessons();
    }

    @Override
    public void updateDataStore() {
        lessons.setLessonsToDisplay(lessonsToDisplay);
    }

    @Override
    public String handleNextRoute() {
        return Routes.DISPLAY_LESSONS;
    }
}
