package Data.Observer.Booking;

import Models.Event.Booking;

import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<Booking> booking);
}
