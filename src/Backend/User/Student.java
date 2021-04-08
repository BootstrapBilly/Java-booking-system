package Backend.User;

import Backend.Lesson.Lesson;

public class Student extends Person {
    private Lesson[] lessons;

    public Student(String name, String address, String phone) {
        super( name, address, phone);
    }

    public void printDetails(){
        System.out.println("ID: " + super.getId());
        System.out.println("Name: " + super.getName());
        System.out.println("Address: " + super.getAddress());
        System.out.println("Phone: " + super.getPhone());
    }
}
