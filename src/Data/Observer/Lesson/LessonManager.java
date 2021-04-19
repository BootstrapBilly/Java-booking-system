package Data.Observer.Lesson;

import Models.Lesson.Lesson;
import Models.User.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class LessonManager implements Subject {

    private ArrayList<Observer> observers;
    private ArrayList<Lesson> lessons;
    private ArrayList<Lesson> lessonsToDisplay;

    public LessonManager() {
        observers = new ArrayList<Observer>();
        lessons = new ArrayList<Lesson>();
        lessonsToDisplay = new ArrayList<Lesson>();
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
            obs.update(lessons);
        }
    }

    public void bookLesson(String id){
        for(Lesson l : lessons){
            if(l.getID() == id){
                l.incrementCapacity();
            }
        }
        notifyObservers();
    }

    public void addLessons(Lesson[] lessons){
        this.lessons.addAll(Arrays.asList(lessons));
        notifyObservers();
    }


    public void setLessonsToDisplay(Lesson[] lessons){
        lessonsToDisplay = new ArrayList<>(Arrays.asList(lessons));
        notifyObservers();
    }

    public Lesson getLessonById(String ID){
        Iterator<Lesson> lessonsIterator = this.lessons.iterator();
        while(lessonsIterator.hasNext()){
            Lesson next = lessonsIterator.next();
            if(next.getID() == ID){
                return next;
            }
        }

        return null;
    }

    public ArrayList<Lesson> getLessonsToDisplay() {
        return lessonsToDisplay;
    }
}
