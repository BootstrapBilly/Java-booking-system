package Data.Observer.Users;

import Backend.User.User;

import java.util.ArrayList;
import java.util.Iterator;

public class UsersObserver implements Observer {

    private ArrayList<User> users;

    private static int observerIDTracker = 0;

    private int observerID;

    private Data.Observer.Users.Subject usersGrabber;

    public UsersObserver(Subject usersGrabber) {

        this.usersGrabber = usersGrabber;
        this.observerID = ++observerIDTracker;

        usersGrabber.register(this);
    }

    public ArrayList<User> getUsers(){
        return this.users;
    }

    @Override
    public void update(ArrayList<User> users) {
        this.users = users;
    }
}
