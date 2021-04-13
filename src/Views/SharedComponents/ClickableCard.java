package Views.SharedComponents;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;

import static Views.Util.Methods.setFontSize;

public class ClickableCard {

    private JButton container;
    private GridBagConstraints gbc = new GridBagConstraints();
    private String text;
    private String ID;
    private ActionListener listener ;
    private String imageName;

    public ClickableCard(String text, String ID, ActionListener listener, String imageName) {
        this.text = text;
        this.ID = ID;
        this.listener = listener;
        this.imageName = imageName;

        setupMainLayout();

        addImage();

        addTitle();
    }

    private void setupMainLayout(){
        container = new JButton();
        container.setLayout(new BorderLayout());
        container.setMargin(new Insets(0,0,0,0));
        container.setBorderPainted(false);
        container.addActionListener(listener);
        container.setName(ID);
    }

    private void addImage(){
        ClassLoader loader = ClickableCard.class.getClassLoader();
        URL url = loader.getResource("Views/Assets/" + imageName);

        JLabel image = new JLabel();
        image.setIcon(new ImageIcon(url));
        container.add(image, BorderLayout.CENTER);
    }

    private void addTitle(){
        JPanel titleContainer = new JPanel(new GridBagLayout());
        titleContainer.setBorder(new EmptyBorder(10,5,10,5));
        JLabel title = new JLabel(text);
        setFontSize(title, 16);
        titleContainer.add(title);
        container.add(titleContainer, BorderLayout.SOUTH);
    }

    public JButton component() { return container; }

}