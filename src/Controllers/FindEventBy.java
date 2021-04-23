package Controllers;

import Constants.Routes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Constants.FindEventBy.COACH;

public class FindEventBy extends EventHandler implements ActionListener {

    // instance variables
    private String choice;

    public FindEventBy() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        choice = ((JButton) e.getSource()).getName(); // extract the given choice
        handleEvent(); // handle the event
    }

    @Override
    public String handleNextRoute(){
        if(choice == COACH){
            return Routes.DISPLAY_COACHES;
        }
        // otherwise it must be activity types
        else return Routes.DISPLAY_ACTIVITY_TYPES;
    }

}
