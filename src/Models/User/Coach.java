package Models.User;

import Models.Event.Appointment;
import Models.Lesson.Lesson;

public class Coach extends Person {
    private String[] expertiseAreas;
    private Appointment[] availableAppointments;
    private Appointment[] bookedAppointments;
    private Lesson[] lessons;

    public Coach(String name, String address, String phone, String[] expertiseAreas, Appointment[] availableAppointments, Appointment[] bookedAppointments, Lesson[] lesson) {
        super( name, address, phone);
        this.expertiseAreas = expertiseAreas;
        this.availableAppointments = availableAppointments;
        this.bookedAppointments = bookedAppointments;
        this.lessons = lesson;
    }

    public Lesson[] getLessons(){
        return this.lessons;
    }

    public Appointment[] getAvailableAppointments() {
        return availableAppointments;
    }
}
