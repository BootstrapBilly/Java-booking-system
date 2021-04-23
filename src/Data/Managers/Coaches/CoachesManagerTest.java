package Data.Managers.Coaches;

import Data.InjectTestData.GenerateEntities;
import Models.User.Coach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoachesManagerTest {

    CoachesManager coaches = Coaches.getInstance();

    @Test
    public void testGetCoachById(){
        GenerateEntities.all(); // generate some test users
        System.out.println("Getting a coach by ID returns the correct coach");

        Coach c = coaches.getCoaches().get(0);

        Coach actual = coaches.getCoachById(c.getID());

        assertEquals(c, actual);
    }

    @Test
    public void testSetSelectedCoach(){
        GenerateEntities.all(); // generate some test users
        System.out.println("Setting a selected coach sets the given coach");

        Coach c = coaches.getCoaches().get(0);

        coaches.setSelectedCoach(c);

        assertEquals(c, coaches.getSelectedCoach());
    }
}
