package Models.User;

import Models.Lesson.Lesson;
import Models.Util.Classes.Entity;
import Models.Util.Classes.TimePeriod;
import Constants.ActivityTypes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoachTest {

    TimePeriod week1 = new TimePeriod(1, 2, 18, 0, 60);

    Lesson f1 = new Lesson("Football", new Entity("Football pitch"), week1, 15);
    Lesson b1 = new Lesson("Basketball", new Entity("Basketball court"), week1, 15);

    Coach testCoach = new Coach("Terry", "1 lane road", "07123456789",
            new String[] {ActivityTypes.FOOTBALL},
            new Lesson[] {f1,b1});

    @Test
    public void testGetLessons(){

        System.out.println("Returns the correct result when the coach has lessons");

        // Arrange
        Lesson[] expected = new Lesson[] {f1,b1};
        String id1 = f1.getID();
        String id2 = b1.getID();

        // Act
        Lesson[] actual = testCoach.getLessons();

        // Assert
        assertEquals(id1, actual[0].getID());
        assertEquals(id2, actual[1].getID());
    }

}