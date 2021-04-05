package Data.Observer.Session;

import Backend.User.User;

import java.util.ArrayList;

public class SessionManager implements Subject {

    private ArrayList<Observer> observers;
    private User user;

    public SessionManager() {
        observers = new ArrayList<Observer>();
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
            obs.update(user);
        }
    }

    public void login(User user){
        this.user = user;
        notifyObservers();
    }

    public void logout(){
        this.user = null;
        notifyObservers();
    }

    public User getSession(){
        return this.user;
    }

}
