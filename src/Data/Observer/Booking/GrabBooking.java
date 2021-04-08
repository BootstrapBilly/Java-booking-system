package Data.Observer.Booking;

import Backend.Event.Booking;
import Backend.Event.Status;
import Backend.Lesson.Lesson;
import Backend.User.Student;
import Backend.Util.Classes.Entity;
import Backend.Util.Classes.TimePeriod;

public class GrabBooking {

    public static void main(String[] args){
        BookingManager bookingManager = new BookingManager();
        BookingObserver observer1 = new BookingObserver(bookingManager);

        Status booked = new Status("Booked");
        TimePeriod time = new TimePeriod(1, 1, 8, 0, 60);
        Entity entity = new Entity("Pitch");
        Lesson lesson = new Lesson("Foozball", entity, time, 3, 0 );
        Student student = new Student("Billy", "road avenue", "013405");

        Booking booking = new Booking(student, lesson, booked);
        Booking booking2 = new Booking(student, lesson, booked);

        bookingManager.addBooking(booking);
        bookingManager.addBooking(booking2);

        bookingManager.printAll();
        booking.updateStatus(new Status("Yeah nah yeah"));

        bookingManager.updateBooking(booking);

        bookingManager.printAll();
    }
}
