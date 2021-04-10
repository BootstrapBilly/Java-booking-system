package Frontend.Screens.CoachSelect;

import Data.Observer.Coaches.CoachesManager;
import Data.Singleton.Coaches;
import Frontend.Handlers.CoachSelectionHandler;
import Frontend.Screens.MainLayout.MainLayout;
import Frontend.SharedComponents.Header;
import javax.swing.*;


public class CoachSelect {

    private MainLayout container;

    public CoachSelect(){
        CoachesManager coaches = Coaches.getInstance();

        this.container = new MainLayout(
                3,
                coaches.getCoaches(),
                new Header(true, "Which coach are you looking for ?"),
                new CoachSelectionHandler());
    }

    public JComponent component() {
        return container.component();
    }
}
