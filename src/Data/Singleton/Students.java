package Data.Singleton;

import Data.Observer.Students.StudentsManager;

public class Students {
    private static StudentsManager uniqueInstance;

    private Students(){};

    public static StudentsManager getInstance(){
        if(uniqueInstance == null){
            StudentsManager studentsManager = new StudentsManager();
            uniqueInstance = studentsManager;
        }
        return uniqueInstance;
    }

}
