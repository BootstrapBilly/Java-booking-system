package Data.Managers.Students;

import Models.User.Student;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentsManager {

    // instance variables
    private ArrayList<Student> students;
    // used when registering a new student
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

        while(studentIterator.hasNext()){ // iterate through all students
            Student next = studentIterator.next();

            if(next.getID() == ID){ // if a match is found
                return next; // return it
            }
        }

        return null; // otherwise, return null
    }

    public String getNewStudentName() {
        return newStudentName;
    }

    public void setNewStudentDetails(String index, String newStudentDetails) {

        /* the inputs which call this method using an internal key listener have been mapped to the ui using a loop
            therefore, each input calls this method with an index, so it knows which field to update
        */
        switch (index){
            case "1": // name field
                this.newStudentName = newStudentDetails;
                break;
            case "2": // address field
                this.newStudentAddress = newStudentDetails;
            case "3": // phone field
                this.newStudentPhone = newStudentDetails;
        }
    }

    public String getNewStudentAddress() {
        return newStudentAddress;
    }

    public String getNewStudentPhone() {
        return newStudentPhone;
    }

}
