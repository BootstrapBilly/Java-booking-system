package Views.Screens.DisplayCoaches;

import Data.Observer.Coaches.CoachesManager;
import Data.Singleton.Coaches;
import Controllers.SelectCoach;
import Views.Screens.MainLayout.MainLayout;
import Views.SharedComponents.Header;
import javax.swing.*;


public class DisplayCoaches {

    private MainLayout container;

    public DisplayCoaches(){
        CoachesManager coaches = Coaches.getInstance();

        this.container = new MainLayout(
                3,
                coaches.getCoaches(),
                new Header(true, "Which coach are you looking for ?"),
                new SelectCoach(),
                20, 20);
    }

    public JComponent component() {
        return container.component();
    }
}
