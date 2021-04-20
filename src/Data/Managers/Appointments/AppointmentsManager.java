package Data.Managers.Appointments;

import Constants.AppointmentStatus;
import Models.Event.Appointment;
import Models.Lesson.Lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class AppointmentsManager {

    private ArrayList<Appointment> appointments;
    private ArrayList<Appointment> appointmentsToDisplay;

    public AppointmentsManager() {
        appointments = new ArrayList<Appointment>();
        appointmentsToDisplay = new ArrayList<Appointment>();
    }

    public void setAppointmentsToDisplay(Appointment[] appointments){
        appointmentsToDisplay = new ArrayList<>(Arrays.asList(appointments));
    }

    public ArrayList<Appointment> getAppointmentsToDisplay() {
        return appointmentsToDisplay;
    }

    public void addAppointments(Appointment[] appointments){
        this.appointments.addAll(Arrays.asList(appointments));
    }

    public void selectAppointment(String appointmentId){
        Appointment app = getAppointmentById(appointmentId);
        app.setStatus(AppointmentStatus.ADDNAME);
    }

    public void cancelSelection(String appointmentId){
        Appointment app = getAppointmentById(appointmentId);
        app.setStatus(AppointmentStatus.AVAILABLE);
    }
    public Appointment getAppointmentById(String ID){
        Iterator<Appointment> appointmentsIterator = this.appointments.iterator();
        while(appointmentsIterator.hasNext()){
            Appointment next = appointmentsIterator.next();
            if(next.getID() == ID){
                return next;
            }
        }

        return null;
    }

}
