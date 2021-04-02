package Backend.Util.Classes;

public class TimePeriod {

    private int week;
    private int day;
    private int startTimeHour;
    private int startTimeMinute;
    private int durationMins;

    public TimePeriod(int week, int day, int startTimeHour, int startTimeMinute, int durationMins) {
        this.week = week;
        this.day = day;
        this.startTimeHour = startTimeHour;
        this.startTimeMinute = startTimeMinute;
        this.durationMins = durationMins;
    }
}
