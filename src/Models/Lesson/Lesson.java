package Models.Lesson;

import Models.Util.Classes.Entity;
import Models.Util.Classes.TimePeriod;

public class Lesson extends Entity {

    // instance variables
    private Entity venue;
    private TimePeriod time;
    private int maxCapacity;
    private int currentCapacity;

    public Lesson(String name, Entity venue, TimePeriod time, int maxCapacity) {
        super( name);
        this.venue = venue;
        this.time = time;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
    }

    public Entity getVenue() {
        return venue;
    }

    public TimePeriod getTime() {
        return time;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void incrementCapacity() {
        this.currentCapacity += 1;
    }

    public void decrementCapacity() {
        this.currentCapacity -= 1;
    }

    public boolean hasSpace(){
        if(currentCapacity >= maxCapacity){
            return false;
        }
        return true;
    }
}
