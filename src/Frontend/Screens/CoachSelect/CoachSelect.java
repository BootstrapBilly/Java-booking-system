package Frontend.Screens.CoachSelect;
import static Constants.FindLessonBy.COACH;
import static Constants.FindLessonBy.TYPE;

import Backend.User.Coach;
import Data.Observer.Coaches.CoachesManager;
import Data.Singleton.Coaches;
import Frontend.Handlers.FindLessonByNavigationHandler;
import Frontend.SharedComponents.ClickableCard;
import Frontend.SharedComponents.Header;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;


public class CoachSelect {

    private JPanel container;
    private JPanel optionDisplayContainer = new JPanel(new GridBagLayout());
    private ArrayList<Coach> coaches;

    static GridBagConstraints gbc = new GridBagConstraints();

    public CoachSelect() {
        CoachesManager coaches = Coaches.getInstance();
        this.coaches = coaches.getCoaches();

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
        Header header = new Header(true, "Which coach are you looking for ?");

        container.add(header.component(), gbc);
    }

    public void addOptions(){

        Iterator coachesIterator = coaches.iterator();

        while(coachesIterator.hasNext()){
            System.out.println(coachesIterator.next());
//            Coach coach = coachesIterator.next();
        }
//        coachesIterator.
//        ClickableCard coach = new ClickableCard(
//                "By " + COACH ,
//                new FindLessonByNavigationHandler(),
//                "lessonType.jpg");
//
//        ClickableCard type = new ClickableCard(
//                "By " + TYPE,
//                new FindLessonByNavigationHandler(),
//                "lessonType.jpg");
//
//        GridBagConstraints optionsGbc = new GridBagConstraints();
//
//        optionsGbc.fill = GridBagConstraints.BOTH;
//        optionsGbc.weightx = 0.5;
//        optionsGbc.weighty = 1;
//        optionsGbc.insets = new Insets(50,30,50,30);
//
//        optionDisplayContainer.add(coach.component(), optionsGbc);
//        optionDisplayContainer.add(type.component(), optionsGbc);
//
//        container.add(optionDisplayContainer, gbc);
    }

    public void styleContainer(){
        container.setBackground(Color.cyan);
    }

    public JPanel component() {
        return container;
    }
}
