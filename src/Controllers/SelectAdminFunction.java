package Controllers;

import Constants.AdminFunctions;
import Constants.Routes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SelectAdminFunction extends EventHandler implements ActionListener {

    // instance variables
    private String choice;

    public SelectAdminFunction() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        choice = ((JButton) e.getSource()).getName();
        handleEvent();
    }

    @Override
    public String handleNextRoute(){
        if(choice == AdminFunctions.ADD_NEW_STUDENT){
            return Routes.REGISTER_STUDENT;
        }
        // otherwise they must have selected generate report
        else return Routes.REPORT_TYPE_SELECT;
    }

}
