package Data.Managers.Users;

import Models.User.User;

import java.util.ArrayList;
import java.util.Iterator;

public class UsersManager {

    //instance variables
    private ArrayList<User> users;

    public UsersManager() {
        users = new ArrayList<User>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public User getUserById(String ID){
        Iterator<User> userIterator = this.users.iterator();

        while(userIterator.hasNext()){ // iterate through all users
            User next = userIterator.next();

            if(next.getID() == ID){ // if a match was found
                return next; // return it
            }
        }

        return null; // otherwise, return null
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
