package Controllers.Appointment;

import Constants.AppointmentStatus;
import Controllers.EventHandler;
import Data.Managers.Appointments.Appointments;
import Data.Managers.Appointments.AppointmentsManager;
import Models.Event.Appointment;
import Views.Router.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectAppointment extends EventHandler implements ActionListener {

    // data managers
    private AppointmentsManager appointments = Appointments.getInstance();
    private Router router = Router.getInstance();

    // instance variables
    private String appointmentId;
    private Appointment selectedAppointment;

    public SelectAppointment() {
        super();
    }

    public void actionPerformed(ActionEvent e) {
        appointmentId = ((JButton) e.getSource()).getName(); // get appointment ID

        handleEvent(); // run event handler
        router.paintScreen(); // re-render screen with new data

    }

    @Override
    public void setupRequiredData() {
        selectedAppointment = appointments.getAppointmentById(appointmentId); // get full appointment object from id
    }

    @Override
    public void updateDataStore() {
        // if the appointment has been booked already
        if (selectedAppointment.getStatus() == AppointmentStatus.BOOKED) {
            return; // do not try to rebook it
        }
        else{ //otherwise
            appointments.selectAppointment(appointmentId); // select the appointment, which will show the name input, cancel and confirm button
        }
    }
}