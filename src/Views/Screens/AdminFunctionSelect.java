package Views.Screens;

import Constants.AdminFunctions;
import Controllers.SelectAdminFunction;
import Views.Screens.Layouts.TwoPanelSelect;
import javax.swing.*;


public class AdminFunctionSelect {

    private TwoPanelSelect container;

    public AdminFunctionSelect(){

        this.container = new TwoPanelSelect(
                "What would you like to do ?",
                AdminFunctions.ADD_NEW_STUDENT, "default_large.png",
                AdminFunctions.GENERATE_REPORT, "reports.jpg",
                new SelectAdminFunction());
    }

    public JComponent component() {
        return container.component();
    }
}
