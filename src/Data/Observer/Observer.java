package Data.Observer;

import Backend.Event.Booking;

public interface Observer {
    public void update(Booking booking);
}
