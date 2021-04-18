package Controllers;

import Views.Router.Router;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackwardsNavigation implements ActionListener {

    public BackwardsNavigation() { super (); }

    public void actionPerformed(ActionEvent e) {
        Router appRouter = Router.getInstance();
        appRouter.goBack();
    }

}