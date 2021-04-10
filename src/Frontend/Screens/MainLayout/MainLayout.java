package Frontend.Screens.MainLayout;

import Backend.User.Object;
import Frontend.SharedComponents.ClickableCard;
import Frontend.SharedComponents.Header;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;


public class MainLayout {

    private JComponent container;
    private JPanel cardDisplayContainer = new JPanel(new GridBagLayout());
    private ArrayList<Object> items;

    private Header header;

    private int limitPerRow;
    private Boolean cleanDivide;
    private int numRows;
    private ArrayList rows = new ArrayList<>();

    private ActionListener itemClickHandler;

    static GridBagConstraints gbc = new GridBagConstraints();

    public MainLayout(int limitPerRow, ArrayList<Object> items, Header header, ActionListener itemClickHandler) {
        this.items = items;
        this.limitPerRow = limitPerRow;
        this.cleanDivide = items.size() % limitPerRow == 0;
        this.numRows = items.size() / limitPerRow;
        this.header = header;
        this.itemClickHandler = itemClickHandler;

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

        displayItems();
    }

    public void addHeader(){
        container.add(this.header.component(), gbc);
    }

    public void displayItems(){
        setUpRows();
        addItemsToRows();

        container.add(cardDisplayContainer, gbc);

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
            cardDisplayContainer.add(row, rowGBC);
        }
    }

    public void addItemsToRows(){
        Iterator itemsIterator = items.iterator();

        int currentRow = 0;
        int index = 0;
        int totalItems = numRows * limitPerRow;
        int remainder = totalItems - items.size();

        while(itemsIterator.hasNext()){

            if(index % limitPerRow == 0 && index > 0){
                currentRow += 1;
            }

            Object object = (Object) itemsIterator.next();
            ClickableCard itemCard = new ClickableCard(object.getName(), itemClickHandler,"lessonType.jpg");

            JPanel row = (JPanel) rows.get(currentRow);
            row.add(itemCard.component());

            if(index + 1 == items.size() && !cleanDivide){
                for(int i = remainder; i > 0; i-=1){
                    JPanel gap = new JPanel(new GridBagLayout());
                    row.add(gap);
                }

            }

            index += 1;

        }
    }

    public JComponent component() {
        return container;
    }
}
