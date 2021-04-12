package Data.Observer.Lesson;

import Models.Lesson.Lesson;

import java.util.ArrayList;

public class LessonObserver implements Observer {

    private ArrayList<Lesson> lessons;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject lessonsGrabber;

    public LessonObserver(Subject lessonsGrabber) {

        this.lessonsGrabber = lessonsGrabber;
        this.observerID = ++observerIDTracker;

        lessonsGrabber.register(this);
    }

    public ArrayList<Lesson> getLessons(){
        return this.lessons;
    }

    @Override
    public void update(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }
}
