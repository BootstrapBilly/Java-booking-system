package Views.Screens;

import Constants.CardTypes;
import Controllers.Appointment.SelectAppointment;
import Data.Managers.Appointments.Appointments;
import Data.Managers.Appointments.AppointmentsManager;
import Views.Screens.Layouts.MainLayout;
import Views.SharedComponents.Header;

import javax.swing.*;

public class DisplayAppointments {

    private MainLayout container;

    public DisplayAppointments(){
        AppointmentsManager appointments = Appointments.getInstance();

        this.container = new MainLayout(
                3,
                appointments.getAppointmentsToDisplay(),
                CardTypes.APPOINTMENT,
                new Header(true, "Which appointment suits you ?"),
                new SelectAppointment(),
                20, 20, true);

    }

    public JComponent component() {
        return container.component();
    }

}
