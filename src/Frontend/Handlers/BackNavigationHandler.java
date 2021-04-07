package Frontend.Handlers;

import Data.Singleton.Router;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackNavigationHandler implements ActionListener {

    public BackNavigationHandler() { super (); }

    public void actionPerformed(ActionEvent e) {

        Router appRouter = Router.getInstance();
        appRouter.goBack();

    }

}