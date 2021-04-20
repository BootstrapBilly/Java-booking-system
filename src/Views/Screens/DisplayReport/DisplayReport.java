package Views.Screens.DisplayReport;

import Constants.ReportTypes;
import Data.Managers.Appointments.Appointments;
import Data.Managers.Appointments.AppointmentsManager;
import Data.Managers.Lessons.LessonManager;
import Data.Managers.Lessons.Lessons;
import Data.Managers.ReportType.ReportType;
import Data.Managers.ReportType.ReportTypeManager;
import Data.Managers.Students.Students;
import Data.Managers.Students.StudentsManager;
import Models.Event.Appointment;
import Models.Lesson.Lesson;
import Models.User.Student;
import Views.Screens.DisplayReport.Components.AppointmentReportItem;
import Views.Screens.DisplayReport.Components.LessonReportItem;
import Views.Screens.DisplayReport.Components.StudentReportItem;
import Views.SharedComponents.Header;
import Views.Util.Methods;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DisplayReport {

    private JPanel container;
    private JPanel recordDisplayContainer = new JPanel(new GridBagLayout());
    private ReportTypeManager reportType = ReportType.getInstance();

    static GridBagConstraints gbc = new GridBagConstraints();
    static GridBagConstraints itemgbc = new GridBagConstraints();

    public DisplayReport() {
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

        addRecords();
    }

    public void addHeader(){
        Header header = new Header(true, reportType.getCurrentReportType());

        container.add(header.component(), gbc);
    }

    public void addRecords(){

        itemgbc.fill = GridBagConstraints.HORIZONTAL;
        itemgbc.weightx = 1;
        itemgbc.insets = new Insets(0,250,5,250);

        switch (reportType.getCurrentReportType()){
            case ReportTypes.LESSONS_AND_APPOINTMENTS:
                addLessonsAndAppointments();
                break;
            case ReportTypes.STUDENT_LESSON_ATTENDANCE:
                addStudentLessonAttendance();
                break;

        }

        JScrollPane scrollPane=new JScrollPane(recordDisplayContainer,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        container.add(scrollPane, gbc);
    }

    public void addLessonsAndAppointments(){
        LessonManager lessons = Lessons.getInstance();
        AppointmentsManager appointments = Appointments.getInstance();

        ArrayList ls = new ArrayList();
        ls.addAll(lessons.getLessons());

        ArrayList aps = new ArrayList();
        aps.addAll(appointments.getAppointments());

        Iterator lessonsIterator = ls.iterator();
        Iterator appointmentsIterator = aps.iterator();

        int index = 0;

        itemgbc.gridy = index;
        JLabel lessonTitle = new JLabel("Lessons");
        Methods.setFontSize(lessonTitle, 18);
        recordDisplayContainer.add(lessonTitle, itemgbc);
        index +=1;

        while (lessonsIterator.hasNext()){
            Lesson next = (Lesson) lessonsIterator.next();
            itemgbc.gridy = index;
            recordDisplayContainer.add(new LessonReportItem(next).component(), itemgbc);
            index +=1;
        }

        itemgbc.gridy = index;
        JLabel appointmentsTitle = new JLabel("Appointments");
        Methods.setFontSize(appointmentsTitle, 18);
        recordDisplayContainer.add(appointmentsTitle, itemgbc);
        index +=1;

        while (appointmentsIterator.hasNext()){
            Appointment next = (Appointment) appointmentsIterator.next();
            itemgbc.gridy = index;
            recordDisplayContainer.add(new AppointmentReportItem(next).component(), itemgbc);
            index +=1;
        }
    }

    public void addStudentLessonAttendance(){
        StudentsManager students = Students.getInstance();

        ArrayList stdn = new ArrayList();
        stdn.addAll(students.getStudents());

        Iterator studentsIterator = stdn.iterator();

        int index = 0;

        while(studentsIterator.hasNext()){
            Student next = (Student) studentsIterator.next();
            itemgbc.gridy = index;
            recordDisplayContainer.add(new StudentReportItem(next).component(), itemgbc);
            index +=1;
        }


    }

    public JPanel component() {
        return container;
    }
}
