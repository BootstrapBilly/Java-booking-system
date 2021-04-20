package Models.Event;

import Constants.AppointmentStatus;
import Models.Util.Classes.TimePeriod;

import java.util.UUID;

public class Appointment {

    private String ID;
    private String parentName = null;
    private TimePeriod time;
    private String status = AppointmentStatus.AVAILABLE;

    public Appointment(TimePeriod time) {
        this.ID = UUID.randomUUID().toString();
        this.time = time;
    }

    public String getID() {
        return ID;
    }

    public TimePeriod getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
