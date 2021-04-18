package Views.Screens.DisplayLessons;
// @refactor -> wrapped this in a singleton to prevent the buttons from being rendered twice when navigating backwards
public class DL {
    private static DisplayLessons uniqueInstance;

    private DL(){};

    public static DisplayLessons getInstance(){
        if(uniqueInstance == null){
            DisplayLessons displayLessons = new DisplayLessons();
            uniqueInstance = displayLessons;
        }
        return uniqueInstance;
    }
}