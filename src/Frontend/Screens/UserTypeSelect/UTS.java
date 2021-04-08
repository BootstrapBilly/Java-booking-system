package Frontend.Screens.UserTypeSelect;
// @refactor -> wrapped this in a singleton to prevent the buttons from being rendered twice when navigating backwards
public class UTS {
    private static UserTypeSelect uniqueInstance;

    private UTS(){};

    public static UserTypeSelect getInstance(){
        if(uniqueInstance == null){
            UserTypeSelect userTypeSelect = new UserTypeSelect();
            uniqueInstance = userTypeSelect;
        }
        return uniqueInstance;
    }
}