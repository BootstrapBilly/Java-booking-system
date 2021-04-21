package Data.Managers.Lessons;

import Data.Managers.ActivityType.ActivityType;
import Data.Managers.ActivityType.ActivityTypeManager;
import Models.Lesson.Lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class LessonsManager {

    private ArrayList<Lesson> lessons;
    private ArrayList<Lesson> lessonsToDisplay;

    public LessonsManager() {
        lessons = new ArrayList<Lesson>();
        lessonsToDisplay = new ArrayList<Lesson>();
    }

    public void bookLesson(String id){
        for(Lesson l : lessons){
            if(l.getID() == id){
                l.incrementCapacity();
            }
        }
    }

    public void cancelLesson(String id) {
        for(Lesson l : lessons){
            if(l.getID() == id){
                l.decrementCapacity();
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
        ActivityTypeManager activityTypes = ActivityType.getInstance();
        ArrayList lessonsToDisplay = new ArrayList();
        Iterator<Lesson> lessonsIterator = this.lessons.iterator();
        while(lessonsIterator.hasNext()){
            Lesson next = lessonsIterator.next();
            if(next.getName() == activityTypes.getCurrentActivityType()){
                lessonsToDisplay.add(next);
            }
        }
        this.lessonsToDisplay = lessonsToDisplay;

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

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }
}
