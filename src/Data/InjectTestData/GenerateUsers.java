package Data.InjectTestData;

import Backend.User.User;
import Data.Observer.Users.UsersManager;
import Data.Singleton.Users;

public class GenerateUsers {
    public static void all(){
        UsersManager usersManager = Users.getManager();

        // students
        usersManager.addUser(new User("1", "Billy", false, true, false));
        usersManager.addUser(new User("2", "James", false, true, false));
        usersManager.addUser(new User("3", "Emily", false, true, false));
        usersManager.addUser(new User("4", "Sarah", false, true, false));
        usersManager.addUser(new User("5", "David", false, true, false));

        // admins
        usersManager.addUser(new User("6", "John", true, false, false));
        usersManager.addUser(new User("7", "Jennie", true, false, false));

        // parent
        usersManager.addUser(new User("8", "Parent", false, false, true));
    }
}
