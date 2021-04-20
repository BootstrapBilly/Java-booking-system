package Controllers;

import Constants.Routes;
import Constants.UserTypes;
import Data.Managers.Appointments.Appointments;
import Data.Managers.Appointments.AppointmentsManager;
import Data.Managers.Lessons.LessonManager;
import Data.Managers.Lessons.Lessons;
import Data.Managers.Session.Session;
import Models.Event.Appointment;
import Models.Lesson.Lesson;
import Data.Managers.Coaches.CoachesManager;
import Data.Managers.Coaches.Coaches;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectCoach extends EventHandler implements ActionListener {
    private CoachesManager coaches = Coaches.getInstance();
    private LessonManager lessons = Lessons.getInstance();
    private AppointmentsManager appointments = Appointments.getInstance();

    private String userType = Session.getInstance().getUserType();
    private Boolean isParent = false;

    private String coachID;
    private Lesson[] lessonsToDisplay;
    private Appointment[] appointmentsToDisplay;

    public SelectCoach() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        coachID = ((JButton) e.getSource()).getName();

        handleEvent();
    }

    @Override
    public void setupRequiredData() {
        if(userType == UserTypes.PARENT){
            isParent = true;
        }
        if(isParent){
            appointmentsToDisplay = coaches.getCoachById(coachID).getAvailableAppointments();
        } else {
            lessonsToDisplay = coaches.getCoachById(coachID).getLessons();
        }
    }

    @Override
    public void updateDataStore() {
        if(isParent){
            appointments.setAppointmentsToDisplay(appointmentsToDisplay);
        } else {
            lessons.setLessonsToDisplay(lessonsToDisplay);
        }
    }

    @Override
    public String handleNextRoute() {
        if(isParent){
            return Routes.DISPLAY_APPOINTMENTS;
        } else {
            return Routes.DISPLAY_LESSONS;
        }

    }
}
