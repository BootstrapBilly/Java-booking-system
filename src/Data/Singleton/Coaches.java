package Data.Singleton;

import Data.Observer.Coaches.CoachesManager;

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
