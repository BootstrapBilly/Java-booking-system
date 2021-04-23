package Controllers;

import Constants.Routes;
import Data.Managers.ReportType.ReportType;
import Data.Managers.ReportType.ReportTypeManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SelectReportType extends EventHandler implements ActionListener {

    // state managers
    private ReportTypeManager reportType = ReportType.getInstance();

    // instance variables
    private String choice;

    public SelectReportType() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        choice = ((JButton) e.getSource()).getName();
        handleEvent();
    }

    public void updateDataStore(){
        reportType.setCurrentReportType(choice);
    }

    @Override
    public String handleNextRoute(){
        return Routes.DISPLAY_REPORT;
    }

}
