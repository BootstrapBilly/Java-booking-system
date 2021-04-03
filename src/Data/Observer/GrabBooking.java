package Data.Observer;

import Backend.Event.Booking;
import Backend.Event.Status;
import Backend.Lesson.Lesson;
import Backend.User.Student;
import Backend.Util.Classes.Entity;
import Backend.Util.Classes.TimePeriod;

public class GrabBooking {

    public static void main(String[] args){
        BookingGrabber bookingGrabber = new BookingGrabber();
        BookingObserver observer1 = new BookingObserver(bookingGrabber);

        Status booked = new Status("Booked");
        TimePeriod time = new TimePeriod(1, 1, 8, 0, 60);
        Entity entity = new Entity("1", "Pitch");
        Lesson lesson = new Lesson("1", "Foozball", entity, time, 3, 0 );
        Student student = new Student("1", "Billy", "road avenue", "013405");
        Booking booking = new Booking("1", student, lesson, booked);

        bookingGrabber.updateBooking(booking);
    }
}
