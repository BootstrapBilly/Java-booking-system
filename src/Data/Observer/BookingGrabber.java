package Data.Observer;

import Backend.Event.Booking;

import java.util.ArrayList;

public class BookingGrabber implements Subject {

    private ArrayList<Observer> observers;
    private Booking booking;
//    private ArrayList<Booking> bookings;

    public BookingGrabber() {
        observers = new ArrayList<Observer>();
//        bookings = new ArrayList<Booking>();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
        System.out.println(o + " added");
    }

    @Override
    public void unRegister(Observer o) {
        int toBeDeletedIndex = observers.indexOf(o);
        observers.remove(toBeDeletedIndex);
        System.out.println(o + " removed");
    }

    @Override
    public void notifyObserver() {
        for(Observer obs : observers){
            obs.update(booking);
        }
    }

    public void updateBooking(Booking booking){
        this.booking = booking;
        notifyObserver();
    }
}
