package Views.Screens.Layouts;
import static Constants.FindEventBy.COACH;
import static Constants.FindEventBy.TYPE;

import Constants.UserTypes;
import Controllers.FindEventBy;
import Data.Managers.Session.Session;
import Data.Managers.Session.SessionManager;
import Views.SharedComponents.NavigationCard;
import Views.SharedComponents.Header;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TwoPanelSelect {

    private JPanel container;
    private JPanel optionDisplayContainer = new JPanel(new GridBagLayout());

    private String title;
    private String c1Name;
    private String c1Image;
    private String c2Name;
    private String c2Image;

    private ActionListener clickhandler;

    static GridBagConstraints gbc = new GridBagConstraints();

    public TwoPanelSelect(String title, String c1Name, String c1Image, String c2Name, String c2Image, ActionListener clickHandler) {
        container = new JPanel();
        container.setLayout(new GridBagLayout());

        this.title = title;
        this.clickhandler = clickHandler;
        this.c1Name = c1Name;
        this.c1Image = c1Image;
        this.c2Name = c2Name;
        this.c2Image = c2Image;

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
        Header header = new Header(true, title);

        container.add(header.component(), gbc);
    }

    public void addOptions(){
        NavigationCard c1 = new NavigationCard(
                c1Name,
                c1Name,
                clickhandler,
                c1Image);

        NavigationCard c2 = new NavigationCard(
                c2Name,
                c2Name,
                clickhandler,
                c2Image);

        GridBagConstraints optionsGbc = new GridBagConstraints();

        optionsGbc.fill = GridBagConstraints.BOTH;
        optionsGbc.weightx = 0.5;
        optionsGbc.weighty = 1;
        optionsGbc.insets = new Insets(50,30,50,30);

        optionDisplayContainer.add(c1.component(), optionsGbc);
        optionDisplayContainer.add(c2.component(), optionsGbc);

        container.add(optionDisplayContainer, gbc);
    }

    public void styleContainer(){
        container.setBackground(Color.cyan);
    }

    public JPanel component() {
        return container;
    }
}
