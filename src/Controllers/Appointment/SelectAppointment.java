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

    private AppointmentsManager appointments = Appointments.getInstance();
    private Router router = Router.getInstance();

    private String appointmentId;
    private Appointment selectedAppointment;
    private String appointmentStatus;

    public SelectAppointment() {
        super();
    }

    public void actionPerformed(ActionEvent e) {
        appointmentId = ((JButton) e.getSource()).getName();

        handleEvent();
        router.paintScreen();

    }

    @Override
    public void setupRequiredData() {
        selectedAppointment = appointments.getAppointmentById(appointmentId);
        appointmentStatus = selectedAppointment.getStatus();
    }

    @Override
    public void updateDataStore() {
        if (appointmentStatus == AppointmentStatus.BOOKED) {
            return;
        }
        else{
            appointments.selectAppointment(appointmentId);
        }
    }
}