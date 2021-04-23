package Controllers;

import Data.Managers.Students.Students;
import Data.Managers.Students.StudentsManager;
import Models.User.Student;
import Views.Router.Router;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterStudent extends EventHandler implements ActionListener {

    // state managers
    private StudentsManager students = Students.getInstance();
    private Router router = Router.getInstance();

    // instance variables
    private String newStudentName = null;
    private String newStudentAddress = null;
    private String newStudentPhone= null;

    public RegisterStudent() {super();}

    public void actionPerformed(ActionEvent e) {

        handleEvent();

        // only re-render if all required fields have been provided
        if(newStudentName != null && newStudentAddress != null && newStudentPhone != null) {
            router.paintScreen();
        }

    }

    @Override
    public void setupRequiredData(){
        /*
        - Pull the required data from the studentsManager
        - Each field is set as it is typed, by inline event handlers attached to JTextField in Screens/RegisterStudent
        - Then when the register button is clicked, the data is pulled from the studentsManager
        */
        this.newStudentName = students.getNewStudentName();
        this.newStudentAddress = students.getNewStudentAddress();
        this.newStudentPhone = students.getNewStudentPhone();
    }

    @Override
    public void updateDataStore() {
        // only create the student if the required fields have been provided
        if(newStudentName != null && newStudentAddress != null && newStudentPhone != null) {
            students.addStudent(new Student(newStudentName, newStudentAddress, newStudentPhone));
        }
    }
}