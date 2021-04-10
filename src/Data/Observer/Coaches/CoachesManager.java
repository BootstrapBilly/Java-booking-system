package Data.Observer.Coaches;

import Backend.User.Object;

import java.util.ArrayList;
import java.util.Iterator;

public class CoachesManager implements Subject {

    private ArrayList<Observer> observers;
    private ArrayList<Object> objects;

    public CoachesManager() {
        observers = new ArrayList<Observer>();
        objects = new ArrayList<Object>();
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
            obs.update(objects);
        }
    }

    public void addCoach(Object object){
        this.objects.add(object);
        notifyObservers();
    }

    public ArrayList<Object> getCoaches(){
        return this.objects;
    }

    public Object getCoachById(String ID){
        Iterator<Object> coachIterator = this.objects.iterator();
        while(coachIterator.hasNext()){
            Object next = coachIterator.next();
            if(next.getID() == ID){
                return next;
            }
        }

        return null;
    }

}
