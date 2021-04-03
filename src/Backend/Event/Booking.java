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

    public void printDetails(){
        System.out.println("Booking #" + this.ID);
        System.out.println("\nStudent: \n"); this.student.printDetails();
        System.out.println("\nLesson: \n"); this.lesson.printDetails();
        System.out.println("\nStatus: " + this.status.getStatus());
    }
}
