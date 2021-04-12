
package Data.Singleton;

import Data.Observer.Lesson.LessonManager;

public class Lessons {
    private static LessonManager uniqueInstance;

    private Lessons(){};

    public static LessonManager getInstance(){
        if(uniqueInstance == null){
            LessonManager lessonManager = new LessonManager();
            uniqueInstance = lessonManager;
        }
        return uniqueInstance;
    }
}
