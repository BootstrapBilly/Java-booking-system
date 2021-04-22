package Data.Managers.Students;

import Models.User.Student;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentsManager {

    private ArrayList<Student> students;
    private String newStudentName;
    private String newStudentAddress;
    private String newStudentPhone;

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

    public String getNewStudentName() {
        return newStudentName;
    }

    public void setNewStudentName(String newStudentName) {
        this.newStudentName = newStudentName;
    }

    public String getNewStudentAddress() {
        return newStudentAddress;
    }

    public void setNewStudentAddress(String newStudentAddress) {
        this.newStudentAddress = newStudentAddress;
    }

    public String getNewStudentPhone() {
        return newStudentPhone;
    }

    public void setNewStudentPhone(String newStudentPhone) {
        this.newStudentPhone = newStudentPhone;
    }
}
