package Models.Util.Classes;

public class TimePeriod {

    // instance variables
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

    public String getWeek() {
        String weekString = "";

        int[] four = {0,1,2,3};
        int[] seven = {0,1,2,3,4,5,6,7};

       for(int week : four){
            for(int day : seven){
                weekString = (this.day * this.week) + "/05" + "/2021";
            }
       }

        return weekString;

    }

    public String getDay() {
        String dayString = "";

        switch (day){
            case 1:
                dayString =  "Monday";
                break;
                case 2:
                    dayString =  "Tuesday";
                break;
                case 3:
                    dayString =  "Wednesday";
                break;
                case 4:
                    dayString =  "Thursday";
                break;
                case 5:
                    dayString =  "Friday";
                break;
                case 6:
                    dayString =  "Saturday";
                break;
                case 7:
                    dayString =  "Sunday";
                break;
        }

        return dayString;
    }

    public int getStartTimeHour() {
        return startTimeHour;
    }

    public String getStartTimeMinute() {
        if(startTimeMinute == 0){
            return "00";
        }
        else return String.valueOf(startTimeMinute);
    }

    public int getDurationMins() {
        return durationMins;
    }

}
