package Data.Managers.Users;

public class Users {
    private static UsersManager uniqueInstance;

    private Users(){};

    public static UsersManager getInstance(){
        if(uniqueInstance == null){
            UsersManager usersManager = new UsersManager();
            uniqueInstance = usersManager;
        }
        return uniqueInstance;
    }

}
