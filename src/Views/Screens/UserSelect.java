package Views.Screens;

import Constants.CardTypes;
import Controllers.SelectUser;
import Data.Managers.Students.Students;
import Data.Managers.Students.StudentsManager;
import Views.Screens.Layouts.MainLayout;
import Views.SharedComponents.Header;

import javax.swing.*;


public class UserSelect {

    private MainLayout container;

    public UserSelect(){
        StudentsManager students = Students.getInstance();

        this.container = new MainLayout(
                2,
                students.getStudents(),
                CardTypes.NAVIGATION,
                new Header(true, "Who are you ?"),
                new SelectUser(),
                20, 20, true);
    }

    public JComponent component() {
        return container.component();
    }
}