package Controllers;

import Constants.AdminFunctions;
import Constants.Routes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SelectAdminFunction extends EventHandler implements ActionListener {
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
            System.out.println("handle this later");
            return Routes.REGISTER_STUDENT;
        }
        else return Routes.REPORT_TYPE_SELECT;
    }

}
