package Controllers.Appointment;

import Controllers.EventHandler;
import Data.Managers.Appointments.Appointments;
import Data.Managers.Appointments.AppointmentsManager;
import Views.Router.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelBookAppointment extends EventHandler implements ActionListener {

    // state managers
    private AppointmentsManager appointments = Appointments.getInstance();
    private Router router = Router.getInstance();

    // instance variables
    private String appointmentId;

    public CancelBookAppointment() {
        super();
    }

    public void actionPerformed(ActionEvent e) {
        appointmentId = ((JButton) e.getSource()).getName();

        handleEvent();
        router.paintScreen(); // re-render the page with the updated state

    }


    @Override
    public void updateDataStore() {
            appointments.cancelSelection(appointmentId);
    }
}