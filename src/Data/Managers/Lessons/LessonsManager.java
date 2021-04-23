package Data.Managers.Lessons;

import Data.Managers.ActivityType.ActivityType;
import Data.Managers.ActivityType.ActivityTypeManager;
import Models.Lesson.Lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class LessonsManager {

    // state managers
    private ActivityTypeManager activityTypes = ActivityType.getInstance();

    // instance variables
    private ArrayList<Lesson> lessons;
    private ArrayList<Lesson> lessonsToDisplay;

    public LessonsManager() {
        lessons = new ArrayList<Lesson>();
        lessonsToDisplay = new ArrayList<Lesson>();
    }

    public void bookLesson(String id){
        for(Lesson l : lessons){ // iterate through all lessons
            if(l.getID() == id){ // if the given lesson id matches
                l.incrementCapacity(); // increment the current capacity of it
            }
        }
    }

    public void cancelLesson(String id) {
        for(Lesson l : lessons){ // iterate through all lessons
            if(l.getID() == id){ // if the given lesson id matches
                l.decrementCapacity(); // decrement the current capacity of it
            }
        }
    }

    public void addLessons(Lesson[] lessons){
        this.lessons.addAll(Arrays.asList(lessons));
    }

    public void setLessonsToDisplay(Lesson[] lessons){
        lessonsToDisplay = new ArrayList<>(Arrays.asList(lessons));
    }

    public void setLessonsToDisplayByType(){
        ArrayList lessonsToDisplay = new ArrayList(); // container to store lessons to be displayed

        Iterator<Lesson> lessonsIterator = this.lessons.iterator();

        while(lessonsIterator.hasNext()){ // iterate through all lessons
            Lesson next = lessonsIterator.next();

            // if the lesson is of the type of activity which has been selected
            if(next.getName() == activityTypes.getCurrentActivityType()){
                lessonsToDisplay.add(next); // add it to the lessons to display
            }
        }
        // overwrite the instance variable with the lessons to display
        this.lessonsToDisplay = lessonsToDisplay;

    }

    public Lesson getLessonById(String ID){
        Iterator<Lesson> lessonsIterator = this.lessons.iterator();

        while(lessonsIterator.hasNext()){ // iterate through all lessons
            Lesson next = lessonsIterator.next();

            if(next.getID() == ID){ // if a match is found
                return next; // return it
            }
        }

        return null; // otherwise return null
    }

    public ArrayList<Lesson> getLessonsToDisplay() {
        return lessonsToDisplay;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }
}
