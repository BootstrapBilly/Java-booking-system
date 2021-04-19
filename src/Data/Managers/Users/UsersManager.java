package Data.Managers.Users;

import Models.User.User;

import java.util.ArrayList;
import java.util.Iterator;

public class UsersManager {

    private ArrayList<User> users;

    public UsersManager() {
        users = new ArrayList<User>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public User getUserById(String ID){
        Iterator<User> userIterator = this.users.iterator();
        while(userIterator.hasNext()){
            User next = userIterator.next();
            if(next.getID() == ID){
                return next;
            }
        }

        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
