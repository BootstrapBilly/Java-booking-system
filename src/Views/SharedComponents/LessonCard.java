package Views.SharedComponents;


import Data.Managers.Session.Session;
import Models.Lesson.Lesson;
import Models.User.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static Views.Util.Methods.setFontSize;

public class LessonCard {

    private JButton container;
    private JPanel footerContainer = new JPanel(new BorderLayout());
    private String text;
    private String ID;
    private ActionListener listener ;
    private Lesson lesson;

    public LessonCard(String text, String ID, ActionListener listener, Lesson lesson) {
        this.text = text;
        this.ID = ID;
        this.listener = listener;
        this.lesson = lesson;

        setupMainLayout();

        addBody();

        addFooter();
    }

    private void setupMainLayout(){
        container = new JButton();
        container.setLayout(new BorderLayout());
        container.setMargin(new Insets(0,0,0,0));
        container.setBorderPainted(false);
        container.addActionListener(listener);
        container.setName(ID);
        container.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void addBody(){
        JPanel body = new JPanel(new BorderLayout());
        body.setBorder(new EmptyBorder(10,10,10,10));

        JPanel venueContainer = new JPanel(new GridBagLayout());
        JLabel venue = new JLabel("Venue: " + lesson.getVenue().getName());
        setFontSize(venue, 16);
        venueContainer.add(venue);
        body.add(venueContainer, BorderLayout.NORTH);

        JLabel time = new JLabel("<html>" +
                "Week: " + lesson.getTime().getWeek() + "<br/>" +
                "Day: " + lesson.getTime().getDay() + "<br/>" +
                "Start time: " + lesson.getTime().getStartTimeHour() + ":" + lesson.getTime().getStartTimeMinute() + "<br/>" +
                "Duration: " + lesson.getTime().getDurationMins() + " mins" +
                "</html>");
        setFontSize(time, 14);
        time.setForeground(Color.gray);
        body.add(time, BorderLayout.CENTER);

        container.add(body, BorderLayout.CENTER);
    }

    private void addFooter(){
        footerContainer.setBorder(new EmptyBorder(10,10,10,10));

        addFooterWest();
        addFooterCenter();
        addFooterEast();

        container.add(footerContainer, BorderLayout.SOUTH);
    }

    private void addFooterWest(){

        String current = String.valueOf(lesson.getCurrentCapacity());
        String max = String.valueOf(lesson.getMaxCapacity());
        JLabel spacesLeft = new JLabel(current + "/" + max);
        setFontSize(spacesLeft, 16);
        footerContainer.add(spacesLeft, BorderLayout.WEST);
    }

    private void addFooterCenter(){

        JPanel centerContainer = new JPanel(new GridBagLayout());
        JLabel title = new JLabel(text);
        setFontSize(title, 20);
        centerContainer.add(title);

        footerContainer.add(centerContainer, BorderLayout.CENTER);

    }

    private void addFooterEast(){

        Student student = (Student) Session.getInstance().getSession();

        JComponent eastComponent = null;

        Boolean studentBookedAlready = student.isAttendingLesson(lesson.getID());

        if(studentBookedAlready){
            JButton cancelButton = new JButton("Cancel");
            cancelButton.setBackground(new Color(255, 155, 155));
            cancelButton.setFont(cancelButton.getFont().deriveFont(16));
            cancelButton.addActionListener(listener);
            cancelButton.setName(ID);
            eastComponent = cancelButton;
        }
        else if(lesson.hasSpace()){
            JButton bookButton = new JButton("Book now");
            bookButton.setBackground(new Color(194, 226, 195));
            bookButton.setFont(bookButton.getFont().deriveFont(16));
            bookButton.addActionListener(listener);
            bookButton.setName(ID);
            eastComponent = bookButton;
        } else {
            JLabel full = new JLabel("Full");
            full.setForeground(Color.red);
            setFontSize(full, 16);
            eastComponent = full;
        }
        eastComponent.setBorder(new EmptyBorder(0,0,0,5));
        footerContainer.add(eastComponent, BorderLayout.EAST);
    }

    public JButton component() { return container; }

}