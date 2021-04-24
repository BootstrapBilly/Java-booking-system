package Models.Event;

import Constants.AppointmentStatus;
import Models.User.Coach;
import Models.Util.TimePeriod;

import java.util.UUID;

public class Appointment {

    // instance variables
    private String ID;
    private String parentName = null;
    private TimePeriod time;
    private String status = AppointmentStatus.AVAILABLE;
    private Coach coach;

    public Appointment(TimePeriod time, Coach coach) {
        this.ID = UUID.randomUUID().toString(); // generate a random id for the appointment
        this.time = time;
        this.coach = coach;
    }

    public String getID() {
        return ID;
    }

    public Coach getCoach() {
        return coach;
    }

    public TimePeriod getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParentName() {
        if(parentName == null){
            return "Not booked";
        }
        return parentName;
    }
}
