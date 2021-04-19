package Controllers;

import Constants.Routes;
import Data.Managers.Lessons.LessonManager;
import Data.Managers.Lessons.Lessons;
import Models.Lesson.Lesson;
import Data.Managers.Coaches.CoachesManager;
import Data.Managers.Coaches.Coaches;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectLessonType extends EventHandler implements ActionListener {
    private CoachesManager coaches = Coaches.getInstance();
    private LessonManager lessons = Lessons.getInstance();

    private String typeId;
    private Lesson[] lessonsToDisplay;

    public SelectLessonType() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        typeId = ((JButton) e.getSource()).getName();

        handleEvent();
    }

    @Override
    public void updateDataStore() {
        lessons.setCurrentLessonType(typeId);
        lessons.setLessonsToDisplayByType();
    }

    @Override
    public String handleNextRoute() {
        return Routes.DISPLAY_LESSONS;
    }
}