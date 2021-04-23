package Controllers.Appointment;

import Controllers.EventHandler;
import Data.Managers.Appointments.Appointments;
import Data.Managers.Appointments.AppointmentsManager;
import Views.Router.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookAppointment extends EventHandler implements ActionListener {

    // state managers
    private AppointmentsManager appointments = Appointments.getInstance();
    private Router router = Router.getInstance();

    // instance variables
    private String appointmentId;

    public BookAppointment() {super();}

    public void actionPerformed(ActionEvent e) {
        appointmentId = ((JButton) e.getSource()).getName(); // extract id of appointment

        handleEvent(); // run the event handler
        router.paintScreen(); // re-render the page with the latest data

    }

    @Override
    public void updateDataStore() {
        appointments.confirmBooking(appointmentId);
    }
}