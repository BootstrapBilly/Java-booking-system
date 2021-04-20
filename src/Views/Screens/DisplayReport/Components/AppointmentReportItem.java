package Views.Screens.DisplayReport.Components;
import Models.Event.Appointment;
import Models.Lesson.Lesson;
import Models.Util.Classes.TimePeriod;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AppointmentReportItem {

    private JPanel container;
    private Appointment appointment;

    static GridBagConstraints gbc = new GridBagConstraints();

    public AppointmentReportItem(Appointment appointment) {
        this.appointment = appointment;
        container = new JPanel();
        container.setLayout(new GridBagLayout());

        container.setBackground(new Color(200,200,200,150));
        container.setBorder(new EmptyBorder(5,5,5,50));
        setupMainLayout();
    }

    public void setupMainLayout(){
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = 1;
        gbc.weightx = 0.10;
        gbc.weighty = 1;
        gbc.gridx = 0;

        addCoach();

        gbc.gridx = 1;
        gbc.weightx = 0.2;

        addTime();

        gbc.gridx = 2;
        gbc.weightx = 0.2;

        addParentName();
    }

    public void addCoach(){
        JLabel name = new JLabel(appointment.getCoach().getName());
        container.add(name, gbc);
    }

    public void addTime(){
        TimePeriod tp = appointment.getTime();
        JLabel time = new JLabel("Week " + tp.getWeek() + " " + tp.getDay() + " " + tp.getStartTimeHour() + ":" + tp.getStartTimeMinute());
        container.add(time, gbc);
    }

    public void addParentName(){
        String prefix = "";
        if(appointment.getParentName() != "Not booked"){
            prefix = "Parent: ";
        }
        JLabel studentCount = new JLabel(prefix + appointment.getParentName());
        container.add(studentCount, gbc);
    }

    public JPanel component() {
        return container;
    }
}
