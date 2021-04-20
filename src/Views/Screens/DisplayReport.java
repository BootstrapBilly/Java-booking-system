package Views.Screens;

import Data.Managers.ReportType.ReportType;
import Data.Managers.ReportType.ReportTypeManager;
import Views.SharedComponents.NavigationCard;
import Views.SharedComponents.Header;

import javax.swing.*;
import java.awt.*;

public class DisplayReport {

    private JPanel container;
    private JPanel recordDisplayContainer = new JPanel(new GridBagLayout());
    private ReportTypeManager reportType = ReportType.getInstance();

    static GridBagConstraints gbc = new GridBagConstraints();

    public DisplayReport() {
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

        addRecords();
    }

    public void addHeader(){
        Header header = new Header(true, reportType.getCurrentReportType());

        container.add(header.component(), gbc);
    }

    public void addRecords(){

//        GridBagConstraints optionsGbc = new GridBagConstraints();
//
//        optionsGbc.fill = GridBagConstraints.BOTH;
//        optionsGbc.weightx = 0.5;
//        optionsGbc.weighty = 1;
//        optionsGbc.insets = new Insets(50,30,50,30);
//
//        recordDisplayContainer.add(c1.component(), optionsGbc);
//        recordDisplayContainer.add(c2.component(), optionsGbc);

        container.add(recordDisplayContainer, gbc);
    }

    public void styleContainer(){
        container.setBackground(Color.cyan);
    }

    public JPanel component() {
        return container;
    }
}
