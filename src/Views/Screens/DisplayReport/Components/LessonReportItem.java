package Views.Screens.DisplayReport.Components;
import Models.Lesson.Lesson;
import Models.Util.Classes.TimePeriod;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LessonReportItem {

    private JPanel container;
    private Lesson lesson;

    static GridBagConstraints gbc = new GridBagConstraints();

    public LessonReportItem(Lesson lesson) {
        this.lesson = lesson;
        container = new JPanel();
        container.setLayout(new GridBagLayout());

        container.setBackground(Color.gray);
        container.setBorder(new EmptyBorder(5,5,5,50));
        setupMainLayout();
    }

    public void setupMainLayout(){
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = 1;
        gbc.weightx = 0.10;
        gbc.weighty = 1;
        gbc.gridx = 0;

        addName();

        gbc.gridx = 1;
        gbc.weightx = 0.2;

        addTime();

        gbc.gridx = 2;
        gbc.weightx = 0.2;

        addStudentCount();
    }

    public void addName(){
        JLabel name = new JLabel(lesson.getName());
        container.add(name, gbc);
    }

    public void addTime(){
        TimePeriod tp = lesson.getTime();
        JLabel time = new JLabel("Week " + tp.getWeek() + " " + tp.getDay() + " " + tp.getStartTimeHour() + ":" + tp.getStartTimeMinute());
        container.add(time, gbc);
    }

    public void addStudentCount(){
        JLabel studentCount = new JLabel(String.valueOf(lesson.getCurrentCapacity()) + " attendees");
        container.add(studentCount, gbc);
    }

    public JPanel component() {
        return container;
    }
}
