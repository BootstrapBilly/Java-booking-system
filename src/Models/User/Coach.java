package Models.User;

import Models.Event.Appointment;
import Models.Lesson.Lesson;

public class Coach extends Person {
    private String[] expertiseAreas;
    private Lesson[] lessons;

    public Coach(String name, String address, String phone, String[] expertiseAreas, Lesson[] lesson) {
        super( name, address, phone);
        this.expertiseAreas = expertiseAreas;
        this.lessons = lesson;
    }

    public Lesson[] getLessons(){
        return this.lessons;
    }

}
