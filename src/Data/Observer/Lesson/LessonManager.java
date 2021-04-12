package Data.Observer.Lesson;

import Models.Lesson.Lesson;

import java.util.ArrayList;

public class LessonManager implements Subject {

    private ArrayList<Observer> observers;
    private ArrayList<Lesson> lessons;

    public LessonManager() {
        observers = new ArrayList<Observer>();
        lessons = new ArrayList<Lesson>();
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

    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
        notifyObservers();
    }

}
