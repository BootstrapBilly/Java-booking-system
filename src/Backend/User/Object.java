package Backend.User;

import Backend.Event.Appointment;
import Backend.Lesson.Lesson;

public class Object extends Person {
    private String[] expertiseAreas;
    private Appointment[] availableAppointments;
    private Appointment[] bookedAppointments;
    private Lesson[] lesson;

    public Object(String name, String address, String phone, String[] expertiseAreas, Appointment[] availableAppointments, Appointment[] bookedAppointments, Lesson[] lesson) {
        super( name, address, phone);
        this.expertiseAreas = expertiseAreas;
        this.availableAppointments = availableAppointments;
        this.bookedAppointments = bookedAppointments;
        this.lesson = lesson;
    }
}
