package Views.Screens.DisplayReport.Components;
import Models.Lesson.Lesson;
import Models.User.Student;
import Models.Util.Classes.TimePeriod;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentReportItem {

    private JPanel container;
    private Student student;
    private Color color = new Color(200,200,200,100);

    static GridBagConstraints gbc = new GridBagConstraints();

    public StudentReportItem(Student student) {
        this.student = student;
        container = new JPanel();
        container.setLayout(new GridBagLayout());

        container.setBackground(color);
        container.setBorder(new EmptyBorder(5,5,5,50));
        setupMainLayout();
    }

    public void setupMainLayout(){
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = 1;
        gbc.weightx = 0.20;
        gbc.weighty = 1;
        gbc.gridx = 0;

        addName();

        gbc.gridx = 1;
        gbc.weightx = 0.8;

        addLessons();

    }

    public void addName(){
        JLabel name = new JLabel(student.getName());
        container.add(name, gbc);
    }

    public void addLessons(){
        GridBagConstraints lessonContainerGbc = new GridBagConstraints();

        ArrayList<Lesson> lessons = new ArrayList<>();
        lessons.addAll(student.getLessons());

        JPanel lessonContainer = new JPanel(new GridBagLayout());
        lessonContainer.setBackground(color);

        lessonContainerGbc.fill = GridBagConstraints.HORIZONTAL;

        Iterator lessonsIterator = lessons.iterator();

        int index = 0;

        while(lessonsIterator.hasNext()){
            Lesson next = (Lesson) lessonsIterator.next();

            JLabel lessonName = new JLabel(next.getName());

            TimePeriod tp = next.getTime();
            JLabel time = new JLabel("Week " + tp.getWeek() + " " + tp.getDay() + " " + tp.getStartTimeHour() + ":" + tp.getStartTimeMinute());

            lessonContainerGbc.gridy = index;
            lessonContainerGbc.weightx = 0.2;
            lessonContainer.add(lessonName, lessonContainerGbc);
            lessonContainerGbc.weightx = 0.8;
            lessonContainer.add(time, lessonContainerGbc);
            index += 1;
        }


        container.add(lessonContainer, gbc);
    }

    public JPanel component() {
        return container;
    }
}
