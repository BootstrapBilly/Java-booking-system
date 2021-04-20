package Controllers;

import Constants.Routes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Constants.FindEventBy.COACH;

public class FindEventBy extends EventHandler implements ActionListener {
    private String choice;
    public FindEventBy() {
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
        else return Routes.DISPLAY_ACTIVITY_TYPES;
    }

}
