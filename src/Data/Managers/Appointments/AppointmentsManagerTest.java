package Data.Managers.Appointments;

import Constants.AppointmentStatus;
import Data.InjectTestData.GenerateEntities;
import Models.Event.Appointment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppointmentsManagerTest {

    AppointmentsManager appointments = Appointments.getInstance();

    @Test
    public void testGetParentName(){

        System.out.println("Returns the correct parent name when none have been supplied");

        String expected = "";
        String actual = appointments.getParentName();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetParentName(){

        System.out.println("Returns the correct parent name when it has been set");

        String expected = "Dave";

        appointments.setParentName(expected);

        String actual = appointments.getParentName();

        assertEquals(expected, actual);
    }

    @Test
    public void testConfirmBooking(){
        GenerateEntities.all(); // generate some test users

        System.out.println("Confirming a booking changes the status of it");

        Appointment app = appointments.getAppointments().get(0);

        assertEquals(app.getParentName(), "Not booked");
        assertEquals(app.getStatus(), AppointmentStatus.AVAILABLE);

        String expectedName = "YeahNahYeah";
        String expectedStatus = AppointmentStatus.BOOKED;

        appointments.setParentName(expectedName);
        appointments.confirmBooking(app.getID());

        assertEquals(app.getParentName(), expectedName);
        assertEquals(app.getStatus(), expectedStatus);
    }

    @Test
    public void testGetAppointmentById(){
        GenerateEntities.all(); // generate some test users
        System.out.println("Getting an appointment by ID returns the correct appointment");

        Appointment app = appointments.getAppointments().get(0);

        Appointment actual = appointments.getAppointmentById(app.getID());

        assertEquals(app, actual);

    }
}
