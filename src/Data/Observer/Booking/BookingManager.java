package Data.Observer.Booking;

import Models.Event.Booking;

import java.util.ArrayList;

public class BookingManager implements Subject {

    private ArrayList<Observer> observers;
    private ArrayList<Booking> bookings;

    public BookingManager() {
        observers = new ArrayList<Observer>();
        bookings = new ArrayList<Booking>();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unRegister(Observer o) {
        int toBeDeletedIndex = observers.indexOf(o);
        observers.remove(toBeDeletedIndex);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs : observers){
            obs.update(bookings);
        }
    }

    public int getBookingIndex(Booking booking){ return bookings.indexOf(booking);};

    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    public void removeBooking(Booking booking){
        int toBeDeleted = getBookingIndex(booking);

        bookings.remove(toBeDeleted);
    }

    public void updateBooking(Booking booking){
        int toBeUpdated = getBookingIndex(booking);

        bookings.set(toBeUpdated, booking);
        notifyObservers();
    }

    public void printAll() {
        this.bookings.forEach(booking -> booking.printDetails());
    }
}
