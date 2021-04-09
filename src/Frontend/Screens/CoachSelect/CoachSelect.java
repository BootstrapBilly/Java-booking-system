package Frontend.Screens.CoachSelect;
import static Constants.FindLessonBy.COACH;
import static Constants.FindLessonBy.TYPE;

import Backend.User.Coach;
import Data.Observer.Coaches.CoachesManager;
import Data.Singleton.Coaches;
import Frontend.Handlers.CoachSelectionHandler;
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
        GridBagConstraints optionsGbc = new GridBagConstraints();

        optionsGbc.fill = GridBagConstraints.BOTH;
        optionsGbc.weightx = 0.5;
        optionsGbc.weighty = 0.5;
        optionsGbc.insets = new Insets(200,5,200,5);

        Iterator coachesIterator = coaches.iterator();

        int coachesMappedToUI = 1;

        while(coachesIterator.hasNext()){
            Coach coach = (Coach) coachesIterator.next();
            ClickableCard coachCard = new ClickableCard(coach.getName(), new CoachSelectionHandler(),"lessonType.jpg");
//            if(coachesMappedToUI > 3){
//                optionsGbc.gridy = 2;
//            }
//            else {
//                optionsGbc.gridy = 1;
//            }
            optionDisplayContainer.add(coachCard.component(), optionsGbc);
            System.out.println(coachesMappedToUI);
            System.out.println(coach.getName());
            coachesMappedToUI += 1;
        }
        container.add(optionDisplayContainer, gbc);

    }

    public void styleContainer(){
        container.setBackground(Color.cyan);
    }

    public JPanel component() {
        return container;
    }
}
