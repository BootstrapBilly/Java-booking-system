package Controllers;

import Constants.Routes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindLessonBy extends EventHandler implements ActionListener {
    public FindLessonBy() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        handleNavigation();
    }

    @Override
    public String handleNextRoute(){
        return Routes.DISPLAY_COACHES;
    }

}
