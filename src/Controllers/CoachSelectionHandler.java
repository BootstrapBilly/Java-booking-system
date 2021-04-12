package Controllers;

import Models.Lesson.Lesson;
import Data.Observer.Coaches.CoachesManager;
import Data.Observer.Session.SessionManager;
import Data.Singleton.Coaches;
import Data.Singleton.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoachSelectionHandler implements ActionListener {
    public CoachSelectionHandler() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        // singletons
        SessionManager session = Session.getInstance();
        CoachesManager coaches = Coaches.getInstance();

        String coachID = ((JButton) e.getSource()).getName();
        Lesson[] lessons = coaches.getCoachById(coachID).getLessons();
        for(Lesson l : lessons){
            System.out.println(l.getName());
        }

    }

}
