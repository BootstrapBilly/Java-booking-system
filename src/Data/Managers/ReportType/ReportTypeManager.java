package Data.Managers.ReportType;

public class ReportTypeManager {

    // instance variables
    private String currentReportType = "";

    public ReportTypeManager() {}

    public void setCurrentReportType(String type){
        this.currentReportType = type;
    }

    public String getCurrentReportType() {
        return currentReportType;
    }
}
