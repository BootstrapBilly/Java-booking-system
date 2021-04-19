package Controllers;

import Constants.Routes;
import Data.Managers.ActivityType.ActivityType;
import Data.Managers.ActivityType.ActivityTypeManager;
import Data.Managers.Lessons.LessonManager;
import Data.Managers.Lessons.Lessons;
import Models.Lesson.Lesson;
import Data.Managers.Coaches.CoachesManager;
import Data.Managers.Coaches.Coaches;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectActivityType extends EventHandler implements ActionListener {
    private LessonManager lessons = Lessons.getInstance();
    private ActivityTypeManager activityTypes = ActivityType.getInstance();

    private String typeId;

    public SelectActivityType() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        typeId = ((JButton) e.getSource()).getName();

        handleEvent();
    }

    @Override
    public void updateDataStore() {
        activityTypes.setCurrentActivityType(typeId);
        lessons.setLessonsToDisplayByType();
    }

    @Override
    public String handleNextRoute() {
        return Routes.DISPLAY_LESSONS;
    }
}