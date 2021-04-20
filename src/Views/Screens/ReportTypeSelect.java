package Views.Screens;

import Constants.ReportTypes;
import Controllers.SelectReportType;
import Views.Screens.Layouts.TwoPanelSelect;
import javax.swing.*;


public class ReportTypeSelect {

    private TwoPanelSelect container;

    public ReportTypeSelect(){

        this.container = new TwoPanelSelect(
                "Which type of report ?",
                ReportTypes.LESSONS_AND_APPOINTMENTS, "",
                ReportTypes.STUDENT_LESSON_ATTENDANCE, "",
                new SelectReportType());
    }

    public JComponent component() {
        return container.component();
    }
}