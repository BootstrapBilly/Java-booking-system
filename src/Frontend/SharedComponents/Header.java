package Frontend.SharedComponents;
import Frontend.Util.Methods;
import javax.swing.*;
import java.awt.*;

public class Header {

    private JPanel container;
    private Boolean hasBackButton;
    private String title;
    private GridBagConstraints gbc = new GridBagConstraints();

    public Header(Boolean hasBackButton, String title) {
        container = new JPanel(new GridBagLayout());

        this.hasBackButton = hasBackButton;
        this.title = title;

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;

        addLeftCol();
        addMidCol();
        addRightCol();

    }

    public void addLeftCol(){
        JPanel leftCol = new JPanel(new GridBagLayout());

        if(hasBackButton){
            leftCol.add(new BackButton().component());
        }

        gbc.weightx = 0.1;
        container.add(leftCol, gbc);
    }

    public void addMidCol(){
        JPanel midCol = new JPanel(new GridBagLayout());

        JLabel headerTitle = new JLabel(title);
        Methods.setFontSize(headerTitle, 40);

        midCol.add(headerTitle);

        gbc.weightx = 0.5;
        container.add(midCol, gbc);
    }

    public void addRightCol(){
        JPanel rightCol = new JPanel(new GridBagLayout());
        JLabel c = new JLabel("Logo");

        rightCol.add(c);

        gbc.weightx = 0.1;
        container.add(rightCol, gbc);
    }

    public JPanel component(){
        return container;
    }
}
