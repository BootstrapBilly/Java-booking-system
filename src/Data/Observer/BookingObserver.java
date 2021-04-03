package Data.Observer;

import Backend.Event.Booking;

public class BookingObserver implements Observer {

    private Booking booking;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject bookingGrabber;

    public BookingObserver(Subject bookingGrabber) {

        this.bookingGrabber = bookingGrabber;
        this.observerID = ++observerIDTracker;

//        System.out.println("New Observer " + this.observerID);

        bookingGrabber.register(this);
    }

    @Override
    public void update(Booking booking) {
        this.booking = booking;

//        System.out.println(observerID + "\n");
        booking.printDetails();
    }
}
