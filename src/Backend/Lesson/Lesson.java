package Backend.Lesson;

import Backend.Util.Classes.Entity;
import Backend.Util.Classes.TimePeriod;

public class Lesson extends Entity{
    private Entity venue;
    private TimePeriod timePeriod;
    private int maxCapacity;
    private int currentCapacity;

    public Lesson(String ID, String name, Entity venue, TimePeriod timePeriod, int maxCapacity, int currentCapacity) {
        super(ID, name);
        this.venue = venue;
        this.timePeriod = timePeriod;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }
}
