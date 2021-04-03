package Backend.Lesson;

import Backend.Util.Classes.Entity;
import Backend.Util.Classes.TimePeriod;

public class Lesson extends Entity{
    private Entity venue;
    private TimePeriod time;
    private int maxCapacity;
    private int currentCapacity;

    public Lesson(String ID, String name, Entity venue, TimePeriod time, int maxCapacity, int currentCapacity) {
        super(ID, name);
        this.venue = venue;
        this.time = time;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    public void printDetails(){
        System.out.println("ID: " + super.getID());
        System.out.println("Name: " + super.getName());
        System.out.println("Venue: " + venue.getName());
        System.out.println("Time: "); this.time.printDetails();
        System.out.println("Max Capacity: " + this.maxCapacity);
        System.out.println("Current Capacity: " + this.currentCapacity);
    }
}
