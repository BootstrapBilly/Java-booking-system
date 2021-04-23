package Controllers;

import Constants.Routes;
import Constants.UserTypes;
import Data.Managers.Appointments.Appointments;
import Data.Managers.Appointments.AppointmentsManager;
import Data.Managers.Lessons.LessonsManager;
import Data.Managers.Lessons.Lessons;
import Data.Managers.Session.Session;
import Models.Lesson.Lesson;
import Data.Managers.Coaches.CoachesManager;
import Data.Managers.Coaches.Coaches;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectCoach extends EventHandler implements ActionListener {

    // state managers
    private CoachesManager coaches = Coaches.getInstance();
    private LessonsManager lessons = Lessons.getInstance();
    private AppointmentsManager appointments = Appointments.getInstance();

    // session details
    private String userType = Session.getInstance().getUserType();
    private Boolean isParent = false;

    // instance variables
    private String coachID;
    private Lesson[] lessonsToDisplay;

    public SelectCoach() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        coachID = ((JButton) e.getSource()).getName();

        handleEvent();
    }

    @Override
    public void setupRequiredData() {
        // get the current session, and see if it is a parent who is logged in
        if(userType == UserTypes.PARENT){
            isParent = true; // if so, set parent to true
        }
        if(!isParent) {
            // otherwise fetch the lessons by the coach which has been selected
            lessonsToDisplay = coaches.getCoachById(coachID).getLessons();
        }
    }

    @Override
    public void updateDataStore() {
        // if a parent is logged in
        if(isParent){
            coaches.setSelectedCoach(coaches.getCoachById(coachID));// set the selected coach to the one which was clicked
            appointments.setAppointmentsToDisplayByCoach();// set the appointments to display to the ones offered by the selected coach
        } else {
            // otherwise, if a student is logged in
            lessons.setLessonsToDisplay(lessonsToDisplay); // set the lessons to display, the ones offered by that coach
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
