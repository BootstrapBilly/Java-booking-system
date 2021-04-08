package Data.Observer.Coaches;

import Backend.User.Coach;
import Backend.User.User;

import java.util.ArrayList;
import java.util.Iterator;

public class CoachesManager implements Subject {

    private ArrayList<Observer> observers;
    private ArrayList<Coach> coaches;

    public CoachesManager() {
        observers = new ArrayList<Observer>();
        coaches = new ArrayList<Coach>();
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
            obs.update(coaches);
        }
    }

    public void addCoach(Coach coach){
        this.coaches.add(coach);
        notifyObservers();
    }

    public ArrayList<Coach> getCoaches(){
        return this.coaches;
    }

    public Coach getCoachById(String ID){
        Iterator<Coach> coachIterator = this.coaches.iterator();
        while(coachIterator.hasNext()){
            Coach next = coachIterator.next();
            if(next.getID() == ID){
                return next;
            }
        }

        return null;
    }

}
