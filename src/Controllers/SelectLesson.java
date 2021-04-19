package Controllers;

import Data.Managers.Lessons.LessonManager;
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

    private SessionManager session = Session.getInstance();
    private LessonManager lessons = Lessons.getInstance();
    private Router router = Router.getInstance();

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
        router.paintScreen();

    }

    @Override
    public void setupRequiredData() {
        student = (Student) session.getSession();
        selectedLesson = lessons.getLessonById(lessonId);
        studentBookedAlready = student.isAttendingLesson(lessonId);
    }

    @Override
    public void updateDataStore() {
        if (!selectedLesson.hasSpace()) {
            return;
        }
        if (studentBookedAlready) {
            lessons.cancelLesson(lessonId);
            student.cancelLesson(selectedLesson);
            
        } else {
            lessons.bookLesson(lessonId);
            student.bookLesson(selectedLesson);
        }
    }
}