package Data.Managers.Students;

import Models.User.Student;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentsManager {

    private ArrayList<Student> students;

    public StudentsManager() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public Student getStudentById(String ID){
        Iterator<Student> studentIterator = this.students.iterator();
        while(studentIterator.hasNext()){
            Student next = studentIterator.next();
            if(next.getID() == ID){
                return next;
            }
        }

        return null;
    }

}
