package Data.Observer.Users;

import Models.User.User;

import java.util.ArrayList;
import java.util.Iterator;

public class UsersManager implements Subject {

    private ArrayList<Observer> observers;
    private ArrayList<User> users;

    public UsersManager() {
        observers = new ArrayList<Observer>();
        users = new ArrayList<User>();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unRegister(Observer o) {
        int toBeDeletedIndex = observers.indexOf(o);
        observers.remove(toBeDeletedIndex);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs : observers){
            obs.update(users);
        }
    }

    public void addUser(User user){
        this.users.add(user);
        notifyObservers();
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

}
