package Data.Managers.Coaches;

public class Coaches {
    private static CoachesManager uniqueInstance;

    private Coaches(){};

    public static CoachesManager getInstance(){
        if(uniqueInstance == null){
            CoachesManager coachesManager = new CoachesManager();
            uniqueInstance = coachesManager;
        }
        return uniqueInstance;
    }
}
