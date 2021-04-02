package Backend.Event;

import Backend.Lesson.Lesson;
import Backend.User.Student;

public class Booking {
    private String ID;
    private Student student;
    private Lesson lesson;
    private Status status;

    public Booking(String ID, Student student, Lesson lesson, Status status) {
        this.ID = ID;
        this.student = student;
        this.lesson = lesson;
        this.status = status;
    }
}
