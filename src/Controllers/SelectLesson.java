package Controllers;

import Data.Managers.Lessons.LessonsManager;
import Data.Managers.Session.SessionManager;
import Data.Managers.Lessons.Lessons;
import Data.Managers.Session.Session;
import Models.Lesson.Lesson;
import Models.User.Student;
import Views.Router.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectLesson extends EventHandler implements ActionListener {

    // state managers
    private SessionManager session = Session.getInstance();
    private LessonsManager lessons = Lessons.getInstance();
    private Router router = Router.getInstance();

    // instance variables
    private String lessonId;
    private Student student;
    private Lesson selectedLesson;
    private Boolean studentBookedAlready;

    public SelectLesson() {
        super();
    }

    public void actionPerformed(ActionEvent e) {
        lessonId = ((JButton) e.getSource()).getName();

        handleEvent();
        router.paintScreen(); // re-render ui with the new state

    }

    @Override
    public void setupRequiredData() {
        selectedLesson = lessons.getLessonById(lessonId); // get the full lesson object which they clicked

        student = (Student) session.getSession(); // get the full student object from the session
        studentBookedAlready = student.isAttendingLesson(lessonId); // check if they are booked into the lesson which they clicked
    }

    @Override
    public void updateDataStore() {
        // if the lesson doesn't have space and the student is not already booked in
        if (!selectedLesson.hasSpace() && !studentBookedAlready) {
            return; // do not book them in
        }
        // otherwise if they are booked in
        if (studentBookedAlready) {
            // cancel the booking
            lessons.cancelLesson(lessonId);
            student.cancelLesson(selectedLesson);
            
        }
        // otherwise if they are not booked in and the lesson has space
        else {
            // book them in
            lessons.bookLesson(lessonId);
            student.bookLesson(selectedLesson);
        }
    }
}