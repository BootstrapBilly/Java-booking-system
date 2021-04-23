package Data.Managers.ActivityType;

public class ActivityType {
    private static ActivityTypeManager uniqueInstance;

    private ActivityType(){};

    public static ActivityTypeManager getInstance(){
        if(uniqueInstance == null){
            ActivityTypeManager activityTypeManager = new ActivityTypeManager();
            uniqueInstance = activityTypeManager;
        }
        return uniqueInstance;
    }
}
