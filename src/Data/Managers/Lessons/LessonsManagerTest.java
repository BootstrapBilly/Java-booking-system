package Data.Managers.Lessons;

import Data.InjectTestData.GenerateEntities;
import Models.Lesson.Lesson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LessonsManagerTest {

    LessonsManager lessons = Lessons.getInstance();
    @Test
    public void testGetLessonById(){
        GenerateEntities.all(); // generate some test users
        System.out.println("Getting a lesson by ID returns the correct lesson");

        Lesson l = lessons.getLessons().get(0);

        Lesson actual = lessons.getLessonById(l.getID());

        assertEquals(l, actual);
    }
}
