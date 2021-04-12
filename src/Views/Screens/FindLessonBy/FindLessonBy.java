package Views.Screens.FindLessonBy;
import static Constants.FindLessonBy.COACH;
import static Constants.FindLessonBy.TYPE;

import Views.SharedComponents.ClickableCard;
import Views.SharedComponents.Header;

import javax.swing.*;
import java.awt.*;

public class FindLessonBy {

    private JPanel container;
    private JPanel optionDisplayContainer = new JPanel(new GridBagLayout());

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
                "By " + COACH ,
                "1",
                new Controllers.FindLessonBy(),
                "lessonType.jpg");

        ClickableCard type = new ClickableCard(
                "By " + TYPE,
                "2",
                new Controllers.FindLessonBy(),
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
