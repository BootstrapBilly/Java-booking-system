package Controllers;

import Constants.Routes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static Constants.FindLessonBy.TYPE;
import static Constants.FindLessonBy.COACH;

public class FindLessonBy extends EventHandler implements ActionListener {
    private String choice;
    public FindLessonBy() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        choice = ((JButton) e.getSource()).getName();
        handleEvent();
    }

    @Override
    public String handleNextRoute(){
        if(choice == COACH){
            return Routes.DISPLAY_COACHES;
        }
        else return Routes.DISPLAY_LESSON_TYPES;
    }

}
