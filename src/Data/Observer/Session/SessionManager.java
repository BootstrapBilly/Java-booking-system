package Data.Observer.Session;

import Models.User.User;

import java.util.ArrayList;

public class SessionManager<A> {

    private ArrayList<Observer> observers;
    private String userType;
    private A user;

    public SessionManager() {
        observers = new ArrayList<Observer>();
    }

//    @Override
//    public void register(Observer o) {
//        observers.add(o);
//    }
//
//    @Override
//    public void unRegister(Observer o) {
//        int toBeDeletedIndex = observers.indexOf(o);
//        observers.remove(toBeDeletedIndex);
//    }
//
//    @Override
//    public void notifyObservers() {
//        for(Observer obs : observers){
//            obs.update(user);
//        }
//    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void login(A user){
        this.user = user;
    }

    public void logout(){
        this.user = null;
    }

    public A getSession(){
        return this.user;
    }

}
