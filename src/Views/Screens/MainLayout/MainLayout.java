package Views.Screens.MainLayout;

import Constants.CardTypes;
import Models.Lesson.Lesson;
import Models.Util.Classes.Entity;
import Views.SharedComponents.LessonCard;
import Views.SharedComponents.NavigationCard;
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
    private String cardType;

    private Header header;

    private int rowPadding;
    private int colPadding;

    private int limitPerRow;
    private Boolean cleanDivide;
    private int numRows;
    private ArrayList rows = new ArrayList<>();

    private ActionListener itemClickHandler;

    static GridBagConstraints gbc = new GridBagConstraints();

    public MainLayout(int limitPerRow, ArrayList items, String cardType, Header header, ActionListener itemClickHandler, int rowPadding, int colPadding) {
        this.items = items;
        this.cardType = cardType;
        this.limitPerRow = limitPerRow;
        this.cleanDivide = items.size() % limitPerRow == 0;
        this.numRows = items.size() / limitPerRow;
        this.header = header;
        this.itemClickHandler = itemClickHandler;
        this.rowPadding = rowPadding;
        this.colPadding = colPadding;

        container = new JPanel();
        container.setLayout(new BorderLayout());

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
        container.add(this.header.component(), BorderLayout.NORTH);
    }

    public void displayItems(){
        setUpRows();
        addItemsToRows();

        container.add(cardDisplayContainer, BorderLayout.CENTER);

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

            JComponent cell = addCell(itemsIterator);

            JPanel row = (JPanel) rows.get(currentRow);
            row.add(cell);

            if(index + 1 == items.size() && !cleanDivide){
                for(int i = remainder; i > 0; i-=1){
                    JPanel gap = new JPanel(new GridBagLayout());
                    row.add(gap);
                }

            }

            index += 1;

        }
    }

    public JComponent addCell(Iterator it){

        JComponent card = null;

        switch (cardType){

            case CardTypes.LESSON:
                Lesson l = (Lesson) it.next();
                LessonCard lc = new LessonCard(l.getName(), l.getID(), itemClickHandler, l);
                card = lc.component();
                break;
            default:
                Entity e = (Entity) it.next();
                NavigationCard itemCard = new NavigationCard(e.getName(), e.getID(), itemClickHandler,"lessonType.jpg");
                card = itemCard.component();
        }

        return card;
    }

    public JComponent component() {
        return container;
    }
}
