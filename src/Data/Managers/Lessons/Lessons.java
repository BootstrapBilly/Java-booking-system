
package Data.Managers.Lessons;

public class Lessons {
    private static LessonsManager uniqueInstance;

    private Lessons(){};

    public static LessonsManager getInstance(){
        if(uniqueInstance == null){
            LessonsManager lessonsManager = new LessonsManager();
            uniqueInstance = lessonsManager;
        }
        return uniqueInstance;
    }
}
