package Data.Managers.ActivityType;

import Constants.ActivityTypes;
import Models.Util.Classes.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ActivityTypeManager {

    // instance variables
    private String currentActivityType = "";
    private ArrayList<Entity> activityTypes = new ArrayList<Entity>(
            Arrays.asList(new Entity(ActivityTypes.FOOTBALL), new Entity(ActivityTypes.BASKETBALL), new Entity(ActivityTypes.BADMINTON),
                    new Entity(ActivityTypes.GYMNASTICS), new Entity(ActivityTypes.CRICKET), new Entity(ActivityTypes.SWIMMING))
    ); /* activity types are hard coded, so they can be displayed without fetching any data,
    and used to match an activity id when an activity is selected */

    public ActivityTypeManager() {}

    public ArrayList<Entity> getActivityTypes() {
        return activityTypes;
    }

    public void setCurrentActivityType(String typeId){
        Iterator<Entity> typesIterator = this.activityTypes.iterator();

        while(typesIterator.hasNext()){ // iterate through the activity types
            Entity next = typesIterator.next();

            if(next.getID() == typeId){ // if the given activity id (supplied when clicking an activity type) matches the id of an activity
                this.currentActivityType = next.getName(); // store the matched activity as the selected activity
            }

        }
    }

    public String getCurrentActivityType() {
        return currentActivityType;
    }

}
