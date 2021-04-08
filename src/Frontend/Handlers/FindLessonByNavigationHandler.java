package Frontend.Handlers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindLessonByNavigationHandler implements ActionListener {
    public FindLessonByNavigationHandler() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        String findBy = ((JButton) e.getSource()).getName();

        System.out.println(findBy);
    }

}
