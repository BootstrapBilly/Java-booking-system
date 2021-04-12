package Views.Screens.MainLayout;

import Models.User.Coach;
import Models.Util.Classes.Entity;
import Views.SharedComponents.ClickableCard;
import Views.SharedComponents.Header;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;


public class MainLayout {

    private JComponent container;
    private JPanel cardDisplayContainer;
    private ArrayList items;

    private Header header;

    private int rowPadding;
    private int colPadding;

    private int limitPerRow;
    private Boolean cleanDivide;
    private int numRows;
    private ArrayList rows = new ArrayList<>();

    private ActionListener itemClickHandler;

    static GridBagConstraints gbc = new GridBagConstraints();

    public MainLayout(int limitPerRow, ArrayList items, Header header, ActionListener itemClickHandler, int rowPadding, int colPadding) {
        this.items = items;
        this.limitPerRow = limitPerRow;
        this.cleanDivide = items.size() % limitPerRow == 0;
        this.numRows = items.size() / limitPerRow;
        this.header = header;
        this.itemClickHandler = itemClickHandler;
        this.rowPadding = rowPadding;
        this.colPadding = colPadding;

        container = new JPanel();
        container.setLayout(new GridBagLayout());

        cardDisplayContainer =  new JPanel(new GridLayout(numRows + 1, 1, 10, rowPadding));

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
            JPanel row = new JPanel(new GridLayout(1, limitPerRow, colPadding, 10));
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

            Entity e = (Entity) itemsIterator.next();
            ClickableCard itemCard = new ClickableCard(e.getName(), e.getID(), itemClickHandler,"lessonType.jpg");

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
