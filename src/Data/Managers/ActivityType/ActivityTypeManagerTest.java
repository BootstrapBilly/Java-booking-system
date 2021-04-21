package Data.Managers.ActivityType;

import Constants.ActivityTypes;
import Models.Util.Classes.Entity;
import Views.Router.Router;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityTypeManagerTest {

    private ActivityTypeManager activityTypes = ActivityType.getInstance();

    @Test
    public void testGetAppointmentTypes(){

        System.out.println("Returns the correct activity types");

        ArrayList<Entity> expected = new ArrayList<Entity>(
                Arrays.asList(new Entity(ActivityTypes.FOOTBALL), new Entity(ActivityTypes.BASKETBALL), new Entity(ActivityTypes.BADMINTON),
                        new Entity(ActivityTypes.GYMNASTICS), new Entity(ActivityTypes.CRICKET), new Entity(ActivityTypes.SWIMMING))
        );

        Iterator expectedIterator = expected.iterator();

        // Arrange
        ArrayList<Entity> actual = activityTypes.getActivityTypes();

        int index = 0;
        while(expectedIterator.hasNext()){
            Entity expectedItem = (Entity) expectedIterator.next();

            assertEquals(expectedItem.getName(), actual.get(index).getName());
            index += 1;
        }
    };

    @Test
    public void testGetCurrentActivityType(){

        System.out.println("Returns the correct current activity type when none have been selected");

        String expected = "";
        String actual = activityTypes.getCurrentActivityType();

        assertEquals(expected, actual);
    }
}
