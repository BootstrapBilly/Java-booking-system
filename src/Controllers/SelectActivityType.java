package Controllers;

import Constants.Routes;
import Constants.UserTypes;
import Data.Managers.ActivityType.ActivityType;
import Data.Managers.ActivityType.ActivityTypeManager;
import Data.Managers.Appointments.Appointments;
import Data.Managers.Appointments.AppointmentsManager;
import Data.Managers.Lessons.LessonsManager;
import Data.Managers.Lessons.Lessons;
import Data.Managers.Session.Session;
import Data.Managers.Session.SessionManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectActivityType extends EventHandler implements ActionListener {
    private LessonsManager lessons = Lessons.getInstance();
    private AppointmentsManager appointments = Appointments.getInstance();
    private ActivityTypeManager activityTypes = ActivityType.getInstance();
    private SessionManager session = Session.getInstance();

    private Boolean isParent = false;

    private String typeId;

    public SelectActivityType() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        typeId = ((JButton) e.getSource()).getName();

        handleEvent();
    }

    @Override
    public void setupRequiredData(){
        if(session.getUserType() == UserTypes.PARENT){
            isParent = true;
        }
    }

    @Override
    public void updateDataStore() {
        activityTypes.setCurrentActivityType(typeId);
        if(isParent){
            appointments.setAppointmentsToDisplayByType();
        } else {
            lessons.setLessonsToDisplayByType();
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