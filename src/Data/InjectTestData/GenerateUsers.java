package Data.InjectTestData;

import Backend.User.User;
import Data.Observer.Users.UsersManager;
import Data.Singleton.Users;

public class GenerateUsers {
    public static void all(){
        UsersManager usersManager = Users.getManager();

        // students
        usersManager.addUser(new User("1", "Billy", false, true));
        usersManager.addUser(new User("2", "James", false, true));
        usersManager.addUser(new User("3", "Emily", false, true));
        usersManager.addUser(new User("4", "Sarah", false, true));
        usersManager.addUser(new User("5", "David", false, true));

        // admins
        usersManager.addUser(new User("1", "John", true, false));
        usersManager.addUser(new User("2", "Jennie", true, false));
    }
}
