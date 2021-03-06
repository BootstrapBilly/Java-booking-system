package Views.Screens;

import Constants.CardTypes;
import Controllers.SelectActivityType;
import Data.Managers.ActivityType.ActivityType;
import Data.Managers.ActivityType.ActivityTypeManager;
import Views.Screens.Layouts.MainLayout;
import Views.SharedComponents.Header;
import javax.swing.*;


public class DisplayActivityTypes {

    private MainLayout container;

    public DisplayActivityTypes(){

        ActivityTypeManager activityTypes = ActivityType.getInstance();

        String[] imageUrls = {"football.jpg", "basketball.jpg", "badminton.jpg", "gymnastics.jpg", "cricket.jpg", "swimming.jpg"};

        this.container = new MainLayout(
                3,
                activityTypes.getActivityTypes(),
                CardTypes.NAVIGATION,
                new Header(true, "Which type of activity ?"),
                new SelectActivityType(),
                20, 20, false, imageUrls);
    }

    public JComponent component() {
        return container.component();
    }
}
