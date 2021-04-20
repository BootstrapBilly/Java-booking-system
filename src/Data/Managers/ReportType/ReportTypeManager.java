package Data.Managers.ReportType;

import Constants.ActivityTypes;
import Models.Util.Classes.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ReportTypeManager {

    private String currentReportType = "";

    public ReportTypeManager() {}

    public void setCurrentReportType(String type){
        this.currentReportType = type;
    }

    public String getCurrentReportType() {
        return currentReportType;
    }
}
