package Models.User;

import Models.Event.Appointment;
import Models.Lesson.Lesson;

import java.util.ArrayList;
import java.util.Arrays;

public class Coach extends Person {
    private ArrayList<String> expertiseAreas = new ArrayList<>();
    private Lesson[] lessons;

    public Coach(String name, String address, String phone, String[] expertiseAreas, Lesson[] lesson) {
        super( name, address, phone);
        this.expertiseAreas.addAll(Arrays.asList(expertiseAreas));
        this.lessons = lesson;
    }

    public Lesson[] getLessons(){
        return this.lessons;
    }

    public Boolean hasExpertise(String expertise){
        return expertiseAreas.contains(expertise);
    }
}
