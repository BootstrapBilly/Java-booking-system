package Data.Managers.Appointments;

import Constants.AppointmentStatus;
import Data.Managers.ActivityType.ActivityType;
import Data.Managers.ActivityType.ActivityTypeManager;
import Data.Managers.Coaches.Coaches;
import Data.Managers.Coaches.CoachesManager;
import Models.Event.Appointment;
import Models.Lesson.Lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class AppointmentsManager {

    private ArrayList<Appointment> appointments;
    private ArrayList<Appointment> appointmentsToDisplay;
    private String parentName = "";

    public AppointmentsManager() {
        appointments = new ArrayList<Appointment>();
        appointmentsToDisplay = new ArrayList<Appointment>();
    }

    public void setAppointmentsToDisplayByCoach(){
        CoachesManager coaches = Coaches.getInstance();
        ArrayList appointmentsToDisplay = new ArrayList();
        Iterator<Appointment> appointmentsIterator = this.appointments.iterator();
        while(appointmentsIterator.hasNext()){
            Appointment next = appointmentsIterator.next();
            if(next.getCoach().getName() == coaches.getSelectedCoach().getName()){
                appointmentsToDisplay.add(next);
            }
        }
        this.appointmentsToDisplay = appointmentsToDisplay;
    }

        public void setAppointmentsToDisplayByType(){
        ActivityTypeManager activityTypes = ActivityType.getInstance();
        ArrayList appointmentsToDisplay = new ArrayList();
        Iterator<Appointment> appointmentsIterator = this.appointments.iterator();
        while(appointmentsIterator.hasNext()){
            Appointment next = appointmentsIterator.next();
            if(next.getCoach().hasExpertise(activityTypes.getCurrentActivityType())){
                appointmentsToDisplay.add(next);
            }
        }
        this.appointmentsToDisplay = appointmentsToDisplay;

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

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void confirmBooking(String appointmentId){
        Appointment app = getAppointmentById(appointmentId);
        app.setStatus(AppointmentStatus.BOOKED);
        app.setParentName(this.parentName);
        this.parentName = "";
    }

}
