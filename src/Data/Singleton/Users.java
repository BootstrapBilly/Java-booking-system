package Data.Singleton;

import Data.Observer.Users.UsersManager;
import Data.Observer.Users.UsersObserver;

public class Users {
    private static UsersManager uniqueInstance;
    private static UsersManager manager;
    private static UsersObserver observer;

    private Users(){};

    public static void init(){
        if(manager == null){
            UsersManager usersManager = new UsersManager();
            manager = usersManager;
        }
        if(observer == null){
            UsersObserver usersObserver = new UsersObserver(manager);
            observer = usersObserver;
        }
    }

    public static UsersManager getManager(){
        return manager;
    }

    public static UsersObserver getObserver(){
        return observer;
    }
}
