package Data.Observer.Booking;

import Models.Event.Booking;

import java.util.ArrayList;

public class BookingObserver implements Observer {

    private ArrayList<Booking> bookings;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject bookingGrabber;

    public BookingObserver(Subject bookingGrabber) {
        bookings = new ArrayList<Booking>();

        this.bookingGrabber = bookingGrabber;
        this.observerID = ++observerIDTracker;

        bookingGrabber.register(this);
    }

    @Override
    public void update(ArrayList bookings) {
        this.bookings = bookings;
    }
}
