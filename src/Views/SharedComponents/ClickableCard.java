package Views.SharedComponents;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
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

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.9;
        gbc.gridy = 0;

        addImage();

        gbc.weighty = 0.1;
        gbc.gridy = 1;

        addTitle();
    }

    private void setupMainLayout(){
        container = new JButton();
        container.setLayout(new GridBagLayout());
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
        container.add(image, gbc);
    }

    private void addTitle(){
        JPanel titleContainer = new JPanel(new GridBagLayout());
        JLabel title = new JLabel(text);
        titleContainer.add(title);
        container.add(titleContainer, gbc);
    }

    public JButton component() { return container; }

}