package Views.SharedComponents;


import Constants.AppointmentStatus;
import Controllers.Appointment.BookAppointment;
import Controllers.Appointment.CancelBookAppointment;
import Data.Managers.Appointments.Appointments;
import Data.Managers.Appointments.AppointmentsManager;
import Models.Event.Appointment;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Views.Util.Methods.setFontSize;

public class AppointmentCard {
    private AppointmentsManager appointmentManager = Appointments.getInstance();

    private JButton container;
    private JPanel footerContainer = new JPanel(new BorderLayout());
    private String ID;
    private ActionListener listener ;
    private Appointment appointment;
    private String parentName;

    public AppointmentCard(String ID, ActionListener listener, Appointment appointment) {
        this.ID = ID;
        this.listener = listener;
        this.appointment = appointment;

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
    }

    private void addBody(){
        JPanel body = new JPanel(new BorderLayout());
        body.setBorder(new EmptyBorder(10,10,10,10));

        JPanel coachContainer = new JPanel(new GridBagLayout());
        JLabel coach = new JLabel(appointment.getCoach().getName());
        setFontSize(coach, 16);
        coachContainer.add(coach);
        body.add(coachContainer, BorderLayout.NORTH);

        if(appointment.getStatus() == AppointmentStatus.ADDNAME) {
            JLabel prompt = new JLabel("What is your name ?");
            JTextField input = new JTextField();
            body.add(prompt);
            body.add(input);
            input.addKeyListener(new KeyListener() {

                public void keyTyped(KeyEvent e) {}
                public void keyPressed(KeyEvent e) {}

                @Override
                public void keyReleased(KeyEvent e) {
                    appointmentManager.setParentName(input.getText());
                }
            });
        } else {
            JLabel time = new JLabel("<html>" +
                    "Week: " + appointment.getTime().getWeek() + "<br/>" +
                    "Day: " + appointment.getTime().getDay() + "<br/>" +
                    "Start time: " + appointment.getTime().getStartTimeHour() + ":" + appointment.getTime().getStartTimeMinute() + "<br/>" +
                    "Duration: " + appointment.getTime().getDurationMins() + " mins" +
                    "</html>");
            setFontSize(time, 14);
            time.setForeground(Color.gray);
            body.add(time, BorderLayout.CENTER);
        }

        container.add(body, BorderLayout.CENTER);
    }

    private void addFooter(){
        footerContainer.setBorder(new EmptyBorder(10,10,10,10));

        if(appointment.getStatus() == AppointmentStatus.ADDNAME) {
            addFooterWest();
        }

        addFooterCenter();

        if(appointment.getStatus() != AppointmentStatus.BOOKED) {
            addFooterEast();
        }

        container.add(footerContainer, BorderLayout.SOUTH);
    }

    private void addFooterWest(){

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(255, 155, 155));
        cancelButton.setFont(cancelButton.getFont().deriveFont(16));
        cancelButton.addActionListener(new CancelBookAppointment());
        cancelButton.setName(ID);
        cancelButton.setBorder(new EmptyBorder(0,0,0,5));

        footerContainer.add(cancelButton, BorderLayout.WEST);
    }

    private void addFooterCenter(){

        JPanel centerContainer = new JPanel(new GridBagLayout());
        JLabel title = new JLabel(appointment.getStatus());
        setFontSize(title, 20);
        centerContainer.add(title);

        footerContainer.add(centerContainer, BorderLayout.CENTER);

    }

    private void addFooterEast(){

        Boolean isBeingBooked = false;

        if(appointment.getStatus() == AppointmentStatus.ADDNAME) {
            isBeingBooked = true;
        }

            JButton bookButton = new JButton(isBeingBooked ? "Confirm" : "Book now");
            bookButton.setBackground(new Color(194, 226, 195));
            bookButton.setFont(bookButton.getFont().deriveFont(16));
            bookButton.addActionListener(new BookAppointment());
            bookButton.setName(ID);
            bookButton.setBorder(new EmptyBorder(0,0,0,5));
            footerContainer.add(bookButton, BorderLayout.EAST);

    }

    public JButton component() { return container; }

}
