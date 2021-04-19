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
        for(Lesson l : lessons){
            if(l.getID() == lessonId){
                return true;
            }
        }
        return false;
    }

    public void printDetails(){
        System.out.println("ID: " + super.getId());
        System.out.println("Name: " + super.getName());
        System.out.println("Address: " + super.getAddress());
        System.out.println("Phone: " + super.getPhone());
    }
}
