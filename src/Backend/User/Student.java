package Backend.User;

import Backend.Lesson.Lesson;

public class Student extends Person {
    private Lesson[] lessons;

    public Student(String ID, String name, String address, String phone, Lesson[] lessons) {
        super(ID, name, address, phone);
        this.lessons = lessons;
    }
}
