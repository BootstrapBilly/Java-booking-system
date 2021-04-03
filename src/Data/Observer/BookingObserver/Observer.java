package Data.Observer.BookingObserver;

import Backend.Event.Booking;

import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<Booking> booking);
}
