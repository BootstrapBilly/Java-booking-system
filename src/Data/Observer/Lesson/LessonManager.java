package Data.Observer.Lesson;

import Models.Lesson.Lesson;

import java.util.ArrayList;
import java.util.Arrays;

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

    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
        notifyObservers();
    }

    public void addLessons(Lesson[] lessons){
        this.lessons.addAll(Arrays.asList(lessons));
        notifyObservers();
    }

    public void addLessonToDisplay(){
        this.lessonsToDisplay.add(lessonsToDisplay.get(0));
        notifyObservers();
    }


    public void setLessonsToDisplay(Lesson[] lessons){
        lessonsToDisplay.addAll(Arrays.asList(lessons));
        notifyObservers();
    }

    public ArrayList<Lesson> getLessonsToDisplay() {
        return lessonsToDisplay;
    }
}
