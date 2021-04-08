package Frontend.Screens.FindLessonBy;
import static Constants.UserTypes.ADMIN;
import static Constants.UserTypes.STUDENT;
import Backend.User.User;
import Data.Observer.Session.SessionManager;
import Data.Singleton.Session;
import Frontend.Handlers.FindLessonByNavigationHandler;
import Frontend.SharedComponents.ClickableCard;
import Frontend.SharedComponents.Header;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FindLessonBy {

    private JPanel container;
    private JPanel optionDisplayContainer = new JPanel(new GridBagLayout());

    private ArrayList<User> users;

    static GridBagConstraints gbc = new GridBagConstraints();

    public FindLessonBy() {
        container = new JPanel();
        container.setLayout(new GridBagLayout());

        setupMainLayout();
        styleContainer();
    }

    public void setupMainLayout(){
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.weighty = 0.05;
        gbc.weightx = 1;
        gbc.gridy = 0;

        addHeader();

        gbc.gridy = 1;
        gbc.weighty = 0.95;

        addOptions();
    }

    public void addHeader(){
        Header header = new Header(true, "How would you like to find a lesson ?");

        container.add(header.component(), gbc);
    }

    public void addOptions(){
        ClickableCard coach = new ClickableCard(
                "Coach",
                new FindLessonByNavigationHandler(),
                "lessonType.jpg");

        ClickableCard type = new ClickableCard(
                "Type",
                new FindLessonByNavigationHandler(),
                "lessonType.jpg");

        GridBagConstraints optionsGbc = new GridBagConstraints();

        optionsGbc.fill = GridBagConstraints.BOTH;
        optionsGbc.weightx = 0.5;
        optionsGbc.weighty = 1;
        optionsGbc.insets = new Insets(50,30,50,30);

        optionDisplayContainer.add(coach.component(), optionsGbc);
        optionDisplayContainer.add(type.component(), optionsGbc);

        container.add(optionDisplayContainer, gbc);
    }

    public void styleContainer(){
        container.setBackground(Color.cyan);
    }

    public JPanel component() {
        return container;
    }
}
