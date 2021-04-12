package Views.Screens.CoachSelect;

import Data.Observer.Coaches.CoachesManager;
import Data.Singleton.Coaches;
import Controllers.CoachSelectionHandler;
import Views.Screens.MainLayout.MainLayout;
import Views.SharedComponents.Header;
import javax.swing.*;


public class CoachSelect {

    private MainLayout container;

    public CoachSelect(){
        CoachesManager coaches = Coaches.getInstance();

        this.container = new MainLayout(
                3,
                coaches.getCoaches(),
                new Header(true, "Which coach are you looking for ?"),
                new CoachSelectionHandler(),
                20, 20);
    }

    public JComponent component() {
        return container.component();
    }
}
