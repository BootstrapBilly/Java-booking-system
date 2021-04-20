package Data.InjectTestData;

import Data.Managers.Appointments.Appointments;
import Data.Managers.Appointments.AppointmentsManager;
import Data.Managers.Students.StudentsManager;
import Data.Managers.Students.Students;
import Models.Event.Appointment;
import Models.Lesson.Lesson;
import Models.User.Coach;
import Models.User.Student;
import Models.User.User;
import Models.Util.Classes.Entity;
import Models.Util.Classes.TimePeriod;
import Data.Managers.Coaches.CoachesManager;
import Data.Managers.Lessons.LessonManager;
import Data.Managers.Users.UsersManager;
import Data.Managers.Coaches.Coaches;
import Data.Managers.Lessons.Lessons;
import Data.Managers.Users.Users;
import Constants.ActivityTypes;
import Constants.LessonCapacity;

import java.util.ArrayList;

public class GenerateEntities {
    private static ArrayList <TimePeriod> lessonTimes = new ArrayList<>();
    private static ArrayList <TimePeriod> appointmentTimes = new ArrayList<>();

    public static void all(){
        UsersManager usersManager = Users.getInstance();
        StudentsManager studentsManager = Students.getInstance();
        CoachesManager coachesManager = Coaches.getInstance();
        LessonManager lessonManager = Lessons.getInstance();
        AppointmentsManager appointmentsManager = Appointments.getInstance();

        // times
        generateLessonTimePeriods();
        generateAppointmentTimePeriods();

        // students
        studentsManager.addStudent(new Student("Billy", "1 road rd", "07363526282"));
        studentsManager.addStudent(new Student("James", "2 road rd", "07363526283"));
        studentsManager.addStudent(new Student("Emily", "3 road rd", "07363526284"));
        studentsManager.addStudent(new Student("Sarah", "4 road rd", "07363526285"));
        studentsManager.addStudent(new Student("Dave", "5 road rd", "07363526286"));
        studentsManager.addStudent(new Student("David", "6 road rd", "07363526287"));
        studentsManager.addStudent(new Student("Paulius", "7 road rd", "07363526288"));
        studentsManager.addStudent(new Student("Dovidas", "8 road rd", "07363526289"));
        studentsManager.addStudent(new Student("Derek", "9 road rd", "07363526290"));
        studentsManager.addStudent(new Student("Priya", "10 road rd", "07363526291"));
        studentsManager.addStudent(new Student("Cho", "11 road rd", "07363526292"));
        studentsManager.addStudent(new Student("Freddie", "12 road rd", "07363526293"));
        studentsManager.addStudent(new Student("Phil", "13 road rd", "07363526294"));
        studentsManager.addStudent(new Student("Francis", "14 road rd", "07363526295"));
        studentsManager.addStudent(new Student("Francesca", "15 road rd", "07363526296"));

        usersManager.addUser(new User("Billy", false, true, false));
        usersManager.addUser(new User("James", false, true, false));
        usersManager.addUser(new User("Emily", false, true, false));
        usersManager.addUser(new User("Sarah", false, true, false));
        usersManager.addUser(new User("Mo", false, true, false));

        // admins
        usersManager.addUser(new User("John", true, false, false));
        usersManager.addUser(new User("Jennie", true, false, false));

        // parent
        usersManager.addUser(new User("Parent", false, false, true));

        // lessons
        // week 1
        Lesson f11 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(0), LessonCapacity.FOOTBALL);
        Lesson f12 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(1), LessonCapacity.FOOTBALL);
        Lesson f13 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(2), LessonCapacity.FOOTBALL);
        Lesson b11 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(3), LessonCapacity.BASKETBALL);
        Lesson b12 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(4), LessonCapacity.BASKETBALL);
        Lesson b13 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(5), LessonCapacity.BASKETBALL);
        Lesson s11 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(6), LessonCapacity.SWIMMING);
        Lesson s12 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(7), LessonCapacity.SWIMMING);
        Lesson s13 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(8), LessonCapacity.SWIMMING);
        Lesson c11 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(9), LessonCapacity.CRICKET);
        Lesson c12 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(10), LessonCapacity.CRICKET);
        Lesson c13 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(11), LessonCapacity.CRICKET);
        Lesson bm11 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(12), LessonCapacity.BADMINTON);
        Lesson bm12 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(13), LessonCapacity.BADMINTON);
        Lesson bm13 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(14), LessonCapacity.BADMINTON);
        Lesson bm14 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(15), LessonCapacity.BADMINTON);
        Lesson g11 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(16), LessonCapacity.GYMNASTICS);
        Lesson g12 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(17), LessonCapacity.GYMNASTICS);
        Lesson g13 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(18), LessonCapacity.GYMNASTICS);
        Lesson g14 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(19), LessonCapacity.GYMNASTICS);

        Lesson[] week1 = {f11, f12, f13, b11, b12, b13, s11, s12, s13, c11, c12, c13, bm11, bm12, bm13, bm14, g11, g12, g13, g14};
        lessonManager.addLessons(week1);

        // week 2
        Lesson f21 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(20), LessonCapacity.FOOTBALL);
        Lesson f22 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(21), LessonCapacity.FOOTBALL);
        Lesson f23 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(22), LessonCapacity.FOOTBALL);
        Lesson b21 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(23), LessonCapacity.BASKETBALL);
        Lesson b22 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(24), LessonCapacity.BASKETBALL);
        Lesson b23 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(25), LessonCapacity.BASKETBALL);
        Lesson s21 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(26), LessonCapacity.SWIMMING);
        Lesson s22 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(27), LessonCapacity.SWIMMING);
        Lesson s23 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(28), LessonCapacity.SWIMMING);
        Lesson c21 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(29), LessonCapacity.CRICKET);
        Lesson c22 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(30), LessonCapacity.CRICKET);
        Lesson c23 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(31), LessonCapacity.CRICKET);
        Lesson bm21 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(32), LessonCapacity.BADMINTON);
        Lesson bm22 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(33), LessonCapacity.BADMINTON);
        Lesson bm23 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(34), LessonCapacity.BADMINTON);
        Lesson bm24 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(35), LessonCapacity.BADMINTON);
        Lesson g21 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(36), LessonCapacity.GYMNASTICS);
        Lesson g22 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(37), LessonCapacity.GYMNASTICS);
        Lesson g23 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(38), LessonCapacity.GYMNASTICS);
        Lesson g24 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(39), LessonCapacity.GYMNASTICS);

        Lesson[] week2 = {f21, f22, f23, b21, b22, b23, s21, s22, s23, c21, c22, c23, bm21, bm22, bm23, bm24, g21, g22, g23, g24};
        lessonManager.addLessons(week2);

        // week 3
        Lesson f31 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(40), LessonCapacity.FOOTBALL);
        Lesson f32 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(41), LessonCapacity.FOOTBALL);
        Lesson f33 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(42), LessonCapacity.FOOTBALL);
        Lesson b31 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(43), LessonCapacity.BASKETBALL);
        Lesson b32 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(44), LessonCapacity.BASKETBALL);
        Lesson b33 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(45), LessonCapacity.BASKETBALL);
        Lesson s31 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(46), LessonCapacity.SWIMMING);
        Lesson s32 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(47), LessonCapacity.SWIMMING);
        Lesson s33 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(48), LessonCapacity.SWIMMING);
        Lesson c31 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(49), LessonCapacity.CRICKET);
        Lesson c32 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(50), LessonCapacity.CRICKET);
        Lesson c33 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(51), LessonCapacity.CRICKET);
        Lesson bm31 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(52), LessonCapacity.BADMINTON);
        Lesson bm32 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(53), LessonCapacity.BADMINTON);
        Lesson bm33 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(54), LessonCapacity.BADMINTON);
        Lesson bm34 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(55), LessonCapacity.BADMINTON);
        Lesson g31 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(55), LessonCapacity.GYMNASTICS);
        Lesson g32 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(56), LessonCapacity.GYMNASTICS);
        Lesson g33 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(58), LessonCapacity.GYMNASTICS);
        Lesson g34 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(59), LessonCapacity.GYMNASTICS);

        Lesson[] week3 = {f31, f32, f33, b31, b32, b33, s31, s32, s33, c31, c32, c33, bm31, bm32, bm33, bm34, g31, g32, g33, g34};
        lessonManager.addLessons(week3);

        // week 4
        Lesson f41 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(60), LessonCapacity.FOOTBALL);
        Lesson f42 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(61), LessonCapacity.FOOTBALL);
        Lesson f43 = new Lesson(ActivityTypes.FOOTBALL, new Entity("Football pitch"), lessonTimes.get(62), LessonCapacity.FOOTBALL);
        Lesson b41 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(63), LessonCapacity.BASKETBALL);
        Lesson b42 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(64), LessonCapacity.BASKETBALL);
        Lesson b43 = new Lesson(ActivityTypes.BASKETBALL, new Entity("Basketball court"), lessonTimes.get(65), LessonCapacity.BASKETBALL);
        Lesson s41 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(66), LessonCapacity.SWIMMING);
        Lesson s42 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(67), LessonCapacity.SWIMMING);
        Lesson s43 = new Lesson(ActivityTypes.SWIMMING, new Entity("Swimming pool"), lessonTimes.get(68), LessonCapacity.SWIMMING);
        Lesson c41 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(69), LessonCapacity.CRICKET);
        Lesson c42 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(70), LessonCapacity.CRICKET);
        Lesson c43 = new Lesson(ActivityTypes.CRICKET, new Entity("Cricket field"), lessonTimes.get(71), LessonCapacity.CRICKET);
        Lesson bm41 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(72), LessonCapacity.BADMINTON);
        Lesson bm42 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(73), LessonCapacity.BADMINTON);
        Lesson bm43 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(74), LessonCapacity.BADMINTON);
        Lesson bm44 = new Lesson(ActivityTypes.BADMINTON, new Entity("Badminton court"), lessonTimes.get(75), LessonCapacity.BADMINTON);
        Lesson g41 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(76), LessonCapacity.GYMNASTICS);
        Lesson g42 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(77), LessonCapacity.GYMNASTICS);
        Lesson g43 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(78), LessonCapacity.GYMNASTICS);
        Lesson g44 = new Lesson(ActivityTypes.GYMNASTICS, new Entity("Gymnasium"), lessonTimes.get(79), LessonCapacity.GYMNASTICS);

        Lesson[] week4 = {f41, f42, f43, b41, b42, b43, s41, s42, s43, c41, c42, c43, bm41, bm42, bm43, bm44, g41, g42, g43, g44};
        lessonManager.addLessons(week4);

        // coaches
        Coach terry = new Coach("Terry", "1 lane road", "07123456789",
                new String[] {ActivityTypes.FOOTBALL},
                new Lesson[] {f11, f12, f21, f22, f31, f32, f41, f42});
        coachesManager.addCoach(terry);

        Coach maria = new Coach("Maria", "2 road avenue", "07987654321",
                new String[] {ActivityTypes.SWIMMING},
                new Lesson[] {s11, s12, s13, s21, s22, s23, c31, c32, c33});
        coachesManager.addCoach(maria);

        Coach nina = new Coach("Nina", "3 avenue crescent", "07974835932",
                new String[] {ActivityTypes.BASKETBALL},
                new Lesson[] {b11, b12, b13, b21, b22, b23, b31, b32, b33});
        coachesManager.addCoach(nina);

        Coach hassan = new Coach("Hassan", "4 random road", "07972084520",
                new String[] {ActivityTypes.BADMINTON, ActivityTypes.FOOTBALL},
                new Lesson[] {f13, f23, f33, f43, bm11, bm12, bm21, bm22, bm31});
        coachesManager.addCoach(hassan);

        Coach demi = new Coach("Demi", "5 long lane", "07983649573",
                new String[] {ActivityTypes.GYMNASTICS, ActivityTypes.SWIMMING},
                new Lesson[] {s31, s32, s33, s41, s42, s43, g11, g12, g13});
        coachesManager.addCoach(demi);

        Coach jeff = new Coach("Jeff", "6 road road", "07983634573",
                new String[] {ActivityTypes.CRICKET, ActivityTypes.BADMINTON},
                new Lesson[] {c11, c12, c13, c21, c22, c23, bm13, bm14});
        coachesManager.addCoach(jeff);

        Coach martha = new Coach("Martha", "7 lane avenue", "07983564573",
                new String[] {ActivityTypes.CRICKET, ActivityTypes.BADMINTON, ActivityTypes.BASKETBALL},
                new Lesson[] {c41, c42, c43, bm32, bm41, bm42, b41, b42, b43});
        coachesManager.addCoach(martha);

        Coach jane = new Coach("Jane", "8 that road", "07983567382",
                new String[] {ActivityTypes.GYMNASTICS},
                new Lesson[] {g14, g21, g22, g23, g24, g31, g32, g33, g34});
        coachesManager.addCoach(jane);

        Coach addi = new Coach("Addi", "9 last avenue", "079835681930",
                new String[] {ActivityTypes.GYMNASTICS, ActivityTypes.BADMINTON},
                new Lesson[] {g41, g42, g43, g44, bm23, bm24, bm33, bm34, bm43, bm44});
        coachesManager.addCoach(addi);

        // appointments
        // week 1
        Appointment w1c1a1 = new Appointment(appointmentTimes.get(0), terry);
        Appointment w1c1a2 = new Appointment(appointmentTimes.get(1), terry);
        Appointment w1c1a3 = new Appointment(appointmentTimes.get(2), terry);
        Appointment w1c2a1 = new Appointment(appointmentTimes.get(3), maria);
        Appointment w1c2a2 = new Appointment(appointmentTimes.get(4), maria);
        Appointment w1c2a3 = new Appointment(appointmentTimes.get(5), maria);
        Appointment w1c3a1 = new Appointment(appointmentTimes.get(6), nina);
        Appointment w1c3a2 = new Appointment(appointmentTimes.get(7), nina);
        Appointment w1c3a3 = new Appointment(appointmentTimes.get(8), nina);
        Appointment w1c4a1 = new Appointment(appointmentTimes.get(9), hassan);
        Appointment w1c4a2 = new Appointment(appointmentTimes.get(10), hassan);
        Appointment w1c4a3 = new Appointment(appointmentTimes.get(11), hassan);
        Appointment w1c5a1 = new Appointment(appointmentTimes.get(12), demi);
        Appointment w1c5a2 = new Appointment(appointmentTimes.get(13), demi);
        Appointment w1c5a3 = new Appointment(appointmentTimes.get(14), demi);
        Appointment w1c6a1 = new Appointment(appointmentTimes.get(15), jeff);
        Appointment w1c6a2 = new Appointment(appointmentTimes.get(16), jeff);
        Appointment w1c6a3 = new Appointment(appointmentTimes.get(17), jeff);
        Appointment w1c7a1 = new Appointment(appointmentTimes.get(18), martha);
        Appointment w1c7a2 = new Appointment(appointmentTimes.get(19), martha);
        Appointment w1c7a3 = new Appointment(appointmentTimes.get(20), martha);
        Appointment w1c8a1 = new Appointment(appointmentTimes.get(21), jane);
        Appointment w1c8a2 = new Appointment(appointmentTimes.get(22), jane);
        Appointment w1c8a3 = new Appointment(appointmentTimes.get(23), jane);
        Appointment w1c9a1 = new Appointment(appointmentTimes.get(24), addi);
        Appointment w1c9a2 = new Appointment(appointmentTimes.get(25), addi);
        Appointment w1c9a3 = new Appointment(appointmentTimes.get(26), addi);

        Appointment[] w1app = {w1c1a1, w1c1a2, w1c1a3, w1c2a1, w1c2a2, w1c2a3, w1c3a1, w1c3a2, w1c3a3, w1c4a1, w1c4a2, w1c4a3, w1c5a1, w1c5a2, w1c5a3,
                w1c6a1, w1c6a2, w1c6a3, w1c7a1, w1c7a2, w1c7a3, w1c8a1, w1c8a2, w1c8a3, w1c9a1, w1c9a2, w1c9a3};
        appointmentsManager.addAppointments(w1app);

        // week 2
        Appointment w2c1a1 = new Appointment(appointmentTimes.get(27), terry);
        Appointment w2c1a2 = new Appointment(appointmentTimes.get(28), terry);
        Appointment w2c1a3 = new Appointment(appointmentTimes.get(29), terry);
        Appointment w2c2a1 = new Appointment(appointmentTimes.get(30), maria);
        Appointment w2c2a2 = new Appointment(appointmentTimes.get(31), maria);
        Appointment w2c2a3 = new Appointment(appointmentTimes.get(32), maria);
        Appointment w2c3a1 = new Appointment(appointmentTimes.get(33), nina);
        Appointment w2c3a2 = new Appointment(appointmentTimes.get(34), nina);
        Appointment w2c3a3 = new Appointment(appointmentTimes.get(35), nina);
        Appointment w2c4a1 = new Appointment(appointmentTimes.get(36), hassan);
        Appointment w2c4a2 = new Appointment(appointmentTimes.get(37), hassan);
        Appointment w2c4a3 = new Appointment(appointmentTimes.get(38), hassan);
        Appointment w2c5a1 = new Appointment(appointmentTimes.get(39), demi);
        Appointment w2c5a2 = new Appointment(appointmentTimes.get(40), demi);
        Appointment w2c5a3 = new Appointment(appointmentTimes.get(41), demi);
        Appointment w2c6a1 = new Appointment(appointmentTimes.get(42), jeff);
        Appointment w2c6a2 = new Appointment(appointmentTimes.get(43), jeff);
        Appointment w2c6a3 = new Appointment(appointmentTimes.get(44), jeff);
        Appointment w2c7a1 = new Appointment(appointmentTimes.get(45), martha);
        Appointment w2c7a2 = new Appointment(appointmentTimes.get(46), martha);
        Appointment w2c7a3 = new Appointment(appointmentTimes.get(47), martha);
        Appointment w2c8a1 = new Appointment(appointmentTimes.get(48), jane);
        Appointment w2c8a2 = new Appointment(appointmentTimes.get(49), jane);
        Appointment w2c8a3 = new Appointment(appointmentTimes.get(50), jane);
        Appointment w2c9a1 = new Appointment(appointmentTimes.get(51), addi);
        Appointment w2c9a2 = new Appointment(appointmentTimes.get(52), addi);
        Appointment w2c9a3 = new Appointment(appointmentTimes.get(53), addi);

        Appointment[] w2app = {w2c1a1, w2c1a2, w2c1a3, w2c2a1, w2c2a2, w2c2a3, w2c3a1, w2c3a2, w2c3a3, w2c4a1, w2c4a2, w2c4a3, w2c5a1, w2c5a2, w2c5a3,
                w2c6a1, w2c6a2, w2c6a3, w2c7a1, w2c7a2, w2c7a3, w2c8a1, w2c8a2, w2c8a3, w2c9a1, w2c9a2, w2c9a3};
        appointmentsManager.addAppointments(w2app);

        Appointment w3c1a1 = new Appointment(appointmentTimes.get(54), terry);
        Appointment w3c1a2 = new Appointment(appointmentTimes.get(55), terry);
        Appointment w3c1a3 = new Appointment(appointmentTimes.get(56), terry);
        Appointment w3c2a1 = new Appointment(appointmentTimes.get(57), maria);
        Appointment w3c2a2 = new Appointment(appointmentTimes.get(58), maria);
        Appointment w3c2a3 = new Appointment(appointmentTimes.get(59), maria);
        Appointment w3c3a1 = new Appointment(appointmentTimes.get(60), nina);
        Appointment w3c3a2 = new Appointment(appointmentTimes.get(61), nina);
        Appointment w3c3a3 = new Appointment(appointmentTimes.get(62), nina);
        Appointment w3c4a1 = new Appointment(appointmentTimes.get(63), hassan);
        Appointment w3c4a2 = new Appointment(appointmentTimes.get(64), hassan);
        Appointment w3c4a3 = new Appointment(appointmentTimes.get(65), hassan);
        Appointment w3c5a1 = new Appointment(appointmentTimes.get(66), demi);
        Appointment w3c5a2 = new Appointment(appointmentTimes.get(67), demi);
        Appointment w3c5a3 = new Appointment(appointmentTimes.get(68), demi);
        Appointment w3c6a1 = new Appointment(appointmentTimes.get(69), jeff);
        Appointment w3c6a2 = new Appointment(appointmentTimes.get(70), jeff);
        Appointment w3c6a3 = new Appointment(appointmentTimes.get(71), jeff);
        Appointment w3c7a1 = new Appointment(appointmentTimes.get(72), martha);
        Appointment w3c7a2 = new Appointment(appointmentTimes.get(73), martha);
        Appointment w3c7a3 = new Appointment(appointmentTimes.get(74), martha);
        Appointment w3c8a1 = new Appointment(appointmentTimes.get(75), jane);
        Appointment w3c8a2 = new Appointment(appointmentTimes.get(76), jane);
        Appointment w3c8a3 = new Appointment(appointmentTimes.get(77), jane);
        Appointment w3c9a1 = new Appointment(appointmentTimes.get(78), addi);
        Appointment w3c9a2 = new Appointment(appointmentTimes.get(79), addi);
        Appointment w3c9a3 = new Appointment(appointmentTimes.get(80), addi);

        Appointment[] w3app = {w3c1a1, w3c1a2, w3c1a3, w3c2a1, w3c2a2, w3c2a3, w3c3a1, w3c3a2, w3c3a3, w3c4a1, w3c4a2, w3c4a3, w3c5a1, w3c5a2, w3c5a3,
                w3c6a1, w3c6a2, w3c6a3, w3c7a1, w3c7a2, w3c7a3, w3c8a1, w3c8a2, w3c8a3, w3c9a1, w3c9a2, w3c9a3};
        appointmentsManager.addAppointments(w3app);

        Appointment w4c1a1 = new Appointment(appointmentTimes.get(81), terry);
        Appointment w4c1a2 = new Appointment(appointmentTimes.get(82), terry);
        Appointment w4c1a3 = new Appointment(appointmentTimes.get(83), terry);
        Appointment w4c2a1 = new Appointment(appointmentTimes.get(84), maria);
        Appointment w4c2a2 = new Appointment(appointmentTimes.get(86), maria);
        Appointment w4c2a3 = new Appointment(appointmentTimes.get(86), maria);
        Appointment w4c3a1 = new Appointment(appointmentTimes.get(87), nina);
        Appointment w4c3a2 = new Appointment(appointmentTimes.get(88), nina);
        Appointment w4c3a3 = new Appointment(appointmentTimes.get(89), nina);
        Appointment w4c4a1 = new Appointment(appointmentTimes.get(90), hassan);
        Appointment w4c4a2 = new Appointment(appointmentTimes.get(91), hassan);
        Appointment w4c4a3 = new Appointment(appointmentTimes.get(92), hassan);
        Appointment w4c5a1 = new Appointment(appointmentTimes.get(93), demi);
        Appointment w4c5a2 = new Appointment(appointmentTimes.get(94), demi);
        Appointment w4c5a3 = new Appointment(appointmentTimes.get(95), demi);
        Appointment w4c6a1 = new Appointment(appointmentTimes.get(96), jeff);
        Appointment w4c6a2 = new Appointment(appointmentTimes.get(97), jeff);
        Appointment w4c6a3 = new Appointment(appointmentTimes.get(98), jeff);
        Appointment w4c7a1 = new Appointment(appointmentTimes.get(99), martha);
        Appointment w4c7a2 = new Appointment(appointmentTimes.get(100), martha);
        Appointment w4c7a3 = new Appointment(appointmentTimes.get(101), martha);
        Appointment w4c8a1 = new Appointment(appointmentTimes.get(102), jane);
        Appointment w4c8a2 = new Appointment(appointmentTimes.get(103), jane);
        Appointment w4c8a3 = new Appointment(appointmentTimes.get(104), jane);
        Appointment w4c9a1 = new Appointment(appointmentTimes.get(105), addi);
        Appointment w4c9a2 = new Appointment(appointmentTimes.get(106), addi);
        Appointment w4c9a3 = new Appointment(appointmentTimes.get(107), addi);

        Appointment[] w4app = {w4c1a1, w4c1a2, w4c1a3, w4c2a1, w4c2a2, w4c2a3, w4c3a1, w4c3a2, w4c3a3, w4c4a1, w4c4a2, w4c4a3, w4c5a1, w4c5a2, w4c5a3,
                w4c6a1, w4c6a2, w4c6a3, w4c7a1, w4c7a2, w4c7a3, w4c8a1, w4c8a2, w4c8a3, w4c9a1, w4c9a2, w4c9a3};
        appointmentsManager.addAppointments(w4app);

    }

    public static void generateLessonTimePeriods(){
        int week = 1;

        int[] days = {1,2,3,4,5};
        int dayIndex = 0;

        int[] hours = {16, 17, 18, 19};
        int hourIndex = 0;

        for(int i = 0; i < 80; i += 1){
            if(i % 20 == 0){
                week += 1;
                dayIndex = 0;
                hourIndex = 0;

            };
            lessonTimes.add(new TimePeriod(week - 1, days[dayIndex], hours[hourIndex], 00, 60));
            if(hourIndex == hours.length - 1){
                hourIndex = 0;
                dayIndex += 1;
            } else {
                hourIndex +=1;
            }
        }
    }

    public static void generateAppointmentTimePeriods(){
        int week = 1;

        int[] days = {1,2,3,4,5};
        int dayIndex = 0;

        int[] hours = {16, 17, 18, 19, 20};
        int hourIndex = 0;

        int[] mins = {0, 20, 40};
        int minIndex = 0;

        for(int i = 0; i < 108; i += 1){
            if(i % 27 == 0){
                week += 1;
                dayIndex = 0;
                hourIndex = 0;
                minIndex = 0;

            };
            TimePeriod t = new TimePeriod(week - 1, days[dayIndex], hours[hourIndex], mins[minIndex], 20);
            appointmentTimes.add(t);
            if(hourIndex == hours.length - 1 && minIndex == 2){
                hourIndex = 0;
                dayIndex += 1;
            }
            if(minIndex == 2){
                minIndex = 0;
                hourIndex +=1;
            } else {
                minIndex += 1;
            }
        }
    }

}
