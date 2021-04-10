package Frontend.Screens.CoachSelect;

import Backend.User.Coach;
import Data.Observer.Coaches.CoachesManager;
import Data.Singleton.Coaches;
import Frontend.Handlers.CoachSelectionHandler;
import Frontend.SharedComponents.ClickableCard;
import Frontend.SharedComponents.Header;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;


public class CoachSelect {

    private JPanel container;
    private JPanel coachesDisplayContainer = new JPanel(new GridBagLayout());
    private ArrayList<Coach> coaches;

    private int limitPerRow = 3;
    private Boolean cleanDivide;
    private int numRows;
    private ArrayList rows = new ArrayList<>();

    static GridBagConstraints gbc = new GridBagConstraints();

    public CoachSelect() {
        CoachesManager coaches = Coaches.getInstance();
        this.coaches = coaches.getCoaches();

        this.cleanDivide = coaches.getCoaches().size() % limitPerRow == 0;
        this.numRows = coaches.getCoaches().size() / limitPerRow;

        container = new JPanel();
        container.setLayout(new GridBagLayout());

        setupMainLayout();
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

        displayCoaches();
    }

    public void addHeader(){
        Header header = new Header(true, "Which coach are you looking for ?");

        container.add(header.component(), gbc);
    }

    public void displayCoaches(){
        setUpRows();
        addCoachesToRows();

        container.add(coachesDisplayContainer, gbc);

    }

    public void setUpRows(){
        if(!cleanDivide){ numRows += 1; }

        GridBagConstraints rowGBC = new GridBagConstraints();

        rowGBC.fill = GridBagConstraints.BOTH;
        rowGBC.weightx = 1;
        rowGBC.weighty = (float) 1 / numRows;

        int currentRow = 0;
        for(int rowsToMap = numRows; rowsToMap > 0; rowsToMap -= 1){
            JPanel row = new JPanel(new GridLayout());
            rowGBC.gridy = currentRow;

            rows.add(row);
            currentRow += 1;
            coachesDisplayContainer.add(row, rowGBC);
        }
    }

    public void addCoachesToRows(){
        Iterator coachesIterator = coaches.iterator();

        int currentRow = 0;
        int index = 0;
        int totalItems = numRows * limitPerRow;
        int remainder = totalItems - coaches.size();

        while(coachesIterator.hasNext()){

            if(index % limitPerRow == 0 && index > 0){
                currentRow += 1;
            }

            Coach coach = (Coach) coachesIterator.next();
            ClickableCard coachCard = new ClickableCard(coach.getName(), new CoachSelectionHandler(),"lessonType.jpg");

            JPanel row = (JPanel) rows.get(currentRow);
            row.add(coachCard.component());

            if(index + 1 == coaches.size() && !cleanDivide){
                for(int i = remainder; i > 0; i-=1){
                    JPanel gap = new JPanel(new GridBagLayout());
                    row.add(gap);
                }

            }

            index += 1;

        }
    }

    public JPanel component() {
        return container;
    }
}
