package Backend.Event;

import Backend.Util.Classes.TimePeriod;

public class Appointment {

    private String ID;
    private String parentName;
    private TimePeriod time;

    public Appointment(String ID, String parentName, TimePeriod time) {
        this.ID = ID;
        this.parentName = parentName;
        this.time = time;
    }
}
