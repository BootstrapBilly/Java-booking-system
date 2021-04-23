package Models.User;

import Models.Lesson.Lesson;

import java.util.ArrayList;

public class Student extends Person {
    private ArrayList<Lesson> lessons = new ArrayList<>();

    public Student(String name, String address, String phone) {
        super( name, address, phone);
    }

    public void bookLesson(Lesson lesson){
        lessons.add(lesson);
    }

    public void cancelLesson(Lesson lesson){
        lessons.remove(lesson);
    }

    public Boolean isAttendingLesson(String lessonId){
        for(Lesson l : lessons){ // loop through all lessons which they are attending
            if(l.getID() == lessonId){ // if the given id matches, they are attending that lesson
                return true; // if they are attending, return true
            }
        }
        return false; // otherwise return false
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }
}
