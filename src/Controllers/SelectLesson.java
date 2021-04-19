package Controllers;

import Data.Observer.Lesson.LessonManager;
import Data.Observer.Session.SessionManager;
import Data.Observer.Users.UsersManager;
import Data.Singleton.Lessons;
import Data.Singleton.Session;
import Data.Singleton.Students;
import Data.Singleton.Users;
import Models.Lesson.Lesson;
import Models.User.Student;
import Views.Router.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectLesson implements ActionListener {
    public SelectLesson() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        String lessonId = ((JButton) e.getSource()).getName();

        // singletons

        SessionManager session = Session.getInstance();
        LessonManager lessons = Lessons.getInstance();

        Student student = (Student) session.getSession();
        Lesson selectedLesson = lessons.getLessonById(lessonId);

        System.out.println(student.getName());

        lessons.bookLesson(lessonId);
        student.bookLesson(selectedLesson);

        Router router = Router.getInstance();
        router.paintScreen();


    }

}
