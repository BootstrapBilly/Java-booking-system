package Controllers;

import Constants.Routes;
import Data.Singleton.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindLessonByNavigationHandler implements ActionListener {
    public FindLessonByNavigationHandler() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        String findBy = ((JButton) e.getSource()).getName();
        Router router = Router.getInstance();
        router.setRoute(Routes.DISPLAY_COACHES);

    }

}
