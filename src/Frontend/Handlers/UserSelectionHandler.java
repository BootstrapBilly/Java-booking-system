package Frontend.Handlers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSelectionHandler implements ActionListener {
    public UserSelectionHandler() {
        super ();
    }

    public void actionPerformed(ActionEvent e) {
        String user = ((JButton) e.getSource()).getName();

        System.out.println(user);
    }

}
