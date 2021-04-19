package Data.Managers.ActivityType;

import Constants.ActivityTypes;
import Models.Util.Classes.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ActivityTypeManager {

    private String currentActivityType = "";
    private ArrayList<Entity> activityTypes = new ArrayList<Entity>(
            Arrays.asList(new Entity(ActivityTypes.FOOTBALL), new Entity(ActivityTypes.BASKETBALL), new Entity(ActivityTypes.BADMINTON),
                    new Entity(ActivityTypes.GYMNASTICS), new Entity(ActivityTypes.CRICKET), new Entity(ActivityTypes.SWIMMING))
    );

    public ActivityTypeManager() {}

    public void setCurrentActivityType(String typeId){
        Iterator<Entity> typesIterator = this.activityTypes.iterator();
        while(typesIterator.hasNext()){
            Entity next = typesIterator.next();
            if(next.getID() == typeId){
                this.currentActivityType = next.getName();
            }
        }
    }

    public ArrayList<Entity> getActivityTypes() {
        return activityTypes;
    }

    public String getCurrentActivityType() {
        return currentActivityType;
    }

}
