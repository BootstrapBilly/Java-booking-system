package Data.Singleton.ScreenProviders;

import Frontend.Screens.Login.UserTypeSelect;

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