package Data.Managers.ReportType;

public class ReportType {
    private static ReportTypeManager uniqueInstance;

    private ReportType(){};

    public static ReportTypeManager getInstance(){
        if(uniqueInstance == null){
            ReportTypeManager reportTypeManager = new ReportTypeManager();
            uniqueInstance = reportTypeManager;
        }
        return uniqueInstance;
    }
}
