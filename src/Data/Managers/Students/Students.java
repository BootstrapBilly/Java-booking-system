package Data.Managers.Students;

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
