package Views.Screens;

import Constants.CardTypes;
import Data.Managers.Coaches.CoachesManager;
import Data.Managers.Coaches.Coaches;
import Controllers.SelectCoach;
import Views.Screens.Layouts.MainLayout;
import Views.SharedComponents.Header;
import javax.swing.*;


public class DisplayCoaches {

    private MainLayout container;

    public DisplayCoaches(){
        CoachesManager coaches = Coaches.getInstance();

        String[] imageUrls = {"terry.jpg", "maria.jpg", "nina.jpg", "hassan.jpg", "demi.jpg", "jeff.jpg", "martha.jpg", "jane.jpg", "addi.jpg"};

        this.container = new MainLayout(
                3,
                coaches.getCoaches(),
                CardTypes.NAVIGATION,
                new Header(true, "Which coach are you looking for ?"),
                new SelectCoach(),
                20, 20, false, imageUrls);
    }

    public JComponent component() {
        return container.component();
    }
}
