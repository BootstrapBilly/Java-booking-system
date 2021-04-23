package Data.Managers.Appointments;

import Constants.AppointmentStatus;
import Data.Managers.ActivityType.ActivityType;
import Data.Managers.ActivityType.ActivityTypeManager;
import Data.Managers.Coaches.Coaches;
import Data.Managers.Coaches.CoachesManager;
import Models.Event.Appointment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class AppointmentsManager {

    // state managers
    private CoachesManager coaches = Coaches.getInstance();
    private ActivityTypeManager activityTypes = ActivityType.getInstance();

    // instance variables
    private ArrayList<Appointment> appointments; // all appointments
    private ArrayList<Appointment> appointmentsToDisplay; // only the ones to be displayed at any given moment
    private String parentName = ""; // parent name when booking an appointment

    public AppointmentsManager() {
        appointments = new ArrayList<Appointment>();
        appointmentsToDisplay = new ArrayList<Appointment>();
    }

    public void setAppointmentsToDisplayByCoach(){
        ArrayList appointmentsToDisplay = new ArrayList(); // array to hold appointments to display

        Iterator<Appointment> appointmentsIterator = this.appointments.iterator();

        while(appointmentsIterator.hasNext()){ // iterate through all available appointments
            Appointment next = appointmentsIterator.next();

            // if the coach of that appointment matches the selected coach
            if(next.getCoach().getName() == coaches.getSelectedCoach().getName()){
                appointmentsToDisplay.add(next); // add it to the appointments to display
            }
        }
        // overwrite the instance variable with the appointments to display
        this.appointmentsToDisplay = appointmentsToDisplay;
    }

        public void setAppointmentsToDisplayByActivity(){
        ArrayList appointmentsToDisplay = new ArrayList();

        Iterator<Appointment> appointmentsIterator = this.appointments.iterator();

        while(appointmentsIterator.hasNext()){// iterate through all available appointments
            Appointment next = appointmentsIterator.next();

            /* if the coach of the appointment has expertise in the current activity type
            (meaning the coach teaches the selected Activity type)  */
            if(next.getCoach().hasExpertise(activityTypes.getCurrentActivityType())){
                appointmentsToDisplay.add(next); // add the appointment to the appointments to display
            }
        }
        // overwrite the instance variable with the appointments to display
        this.appointmentsToDisplay = appointmentsToDisplay;

    }

    public ArrayList<Appointment> getAppointmentsToDisplay() {
        return appointmentsToDisplay;
    }

    public void addAppointments(Appointment[] appointments){
        this.appointments.addAll(Arrays.asList(appointments));
    }

    public void selectAppointment(String appointmentId){
        Appointment app = getAppointmentById(appointmentId); // get the full appointment object
        app.setStatus(AppointmentStatus.ADD_NAME); // set the status to add name, which will render a name input, and confirm/cancel buttons
    }

    public void cancelSelection(String appointmentId){
        Appointment app = getAppointmentById(appointmentId);// get the full appointment object
        app.setStatus(AppointmentStatus.AVAILABLE);// set the status to available, which will remove the name input, confirm/cancel buttons
    }

    public Appointment getAppointmentById(String ID){
        Iterator<Appointment> appointmentsIterator = this.appointments.iterator();

        while(appointmentsIterator.hasNext()){ // iterate through all appointments
            Appointment next = appointmentsIterator.next();

            if(next.getID() == ID){ // if the given id matches, the appointment has been found
                return next; // return it
            }
        }

        return null; // otherwise it has not been found, return null
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void confirmBooking(String appointmentId){
        Appointment app = getAppointmentById(appointmentId); // get the full appointment object

        app.setStatus(AppointmentStatus.BOOKED); // change the status of it to booked
        app.setParentName(this.parentName); // store the given parent name on the appointment

        this.parentName = ""; // reset the parent name stored in this state manager
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public String getParentName() {
        return parentName;
    }
}
