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

public class CancelBookAppointment extends EventHandler implements ActionListener {

    private AppointmentsManager appointments = Appointments.getInstance();
    private Router router = Router.getInstance();

    private String appointmentId;

    public CancelBookAppointment() {
        super();
    }

    public void actionPerformed(ActionEvent e) {
        appointmentId = ((JButton) e.getSource()).getName();

        handleEvent();
        router.paintScreen();

    }


    @Override
    public void updateDataStore() {
            appointments.cancelSelection(appointmentId);
    }
}