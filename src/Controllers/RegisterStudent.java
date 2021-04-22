package Controllers;

import Controllers.EventHandler;
import Data.Managers.Students.Students;
import Data.Managers.Students.StudentsManager;
import Models.User.Student;
import Views.Router.Router;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterStudent extends EventHandler implements ActionListener {

    private StudentsManager students = Students.getInstance();
    private Router router = Router.getInstance();

    private String newStudentName = null;
    private String newStudentAddress = null;
    private String newStudentPhone= null;

    public RegisterStudent() {super();}

    public void actionPerformed(ActionEvent e) {

        System.out.println("inside t' place");
        handleEvent();

        if(newStudentName != null && newStudentAddress != null && newStudentPhone != null) {
            router.paintScreen();
        }

    }

    @Override
    public void setupRequiredData(){
        this.newStudentName = students.getNewStudentName();
    }

    @Override
    public void updateDataStore() {
        if(newStudentName != null && newStudentAddress != null && newStudentPhone != null) {
            students.addStudent(new Student(newStudentName, newStudentAddress, newStudentPhone));
        }
    }
}