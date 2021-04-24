package Models.User;

import Models.Lesson.Lesson;

import java.util.ArrayList;
import java.util.Arrays;

public class Coach extends Person {
    private ArrayList<String> expertiseAreas = new ArrayList<>();
    private Lesson[] lessons;
    private String imageUrl = "";

    public Coach(String name, String address, String phone, String[] expertiseAreas, Lesson[] lesson, String imageUrl) {
        super( name, address, phone);
        this.expertiseAreas.addAll(Arrays.asList(expertiseAreas));
        this.lessons = lesson;
        this.imageUrl = imageUrl;
    }

    public Lesson[] getLessons(){
        return this.lessons;
    }

    public Boolean hasExpertise(String expertise){
        return expertiseAreas.contains(expertise);
    }
}
