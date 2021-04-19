package Data.InjectTestData;

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
import Constants.LessonTypes;
import Constants.LessonCapacity;

import java.util.ArrayList;

public class GenerateEntities {
    private static ArrayList <TimePeriod> times = new ArrayList<>();

    public static void all(){
        UsersManager usersManager = Users.getInstance();
        StudentsManager studentsManager = Students.getInstance();
        CoachesManager coachesManager = Coaches.getInstance();
        LessonManager lessonManager = Lessons.getInstance();

        // times
        generateTimePeriods();

        // students
        studentsManager.addStudent(new Student("Billy", "1 road rd", "07363526282"));
        studentsManager.addStudent(new Student("James", "2 road rd", "07363526283"));
        studentsManager.addStudent(new Student("Emily", "3 road rd", "07363526284"));
        studentsManager.addStudent(new Student("Sarah", "4 road rd", "07363526285"));
        studentsManager.addStudent(new Student("Mo", "5 road rd", "07363526286"));

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
        Lesson f11 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(0), LessonCapacity.FOOTBALL);
        Lesson f12 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(1), LessonCapacity.FOOTBALL);
        Lesson f13 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(2), LessonCapacity.FOOTBALL);
        Lesson b11 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(3), LessonCapacity.BASKETBALL);
        Lesson b12 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(4), LessonCapacity.BASKETBALL);
        Lesson b13 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(5), LessonCapacity.BASKETBALL);
        Lesson s11 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(6), LessonCapacity.SWIMMING);
        Lesson s12 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(7), LessonCapacity.SWIMMING);
        Lesson s13 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(8), LessonCapacity.SWIMMING);
        Lesson c11 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(9), LessonCapacity.CRICKET);
        Lesson c12 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(10), LessonCapacity.CRICKET);
        Lesson c13 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(11), LessonCapacity.CRICKET);
        Lesson bm11 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(12), LessonCapacity.BADMINTON);
        Lesson bm12 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(13), LessonCapacity.BADMINTON);
        Lesson bm13 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(14), LessonCapacity.BADMINTON);
        Lesson bm14 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(15), LessonCapacity.BADMINTON);
        Lesson g11 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(16), LessonCapacity.GYMNASTICS);
        Lesson g12 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(17), LessonCapacity.GYMNASTICS);
        Lesson g13 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(18), LessonCapacity.GYMNASTICS);
        Lesson g14 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(19), LessonCapacity.GYMNASTICS);

        Lesson[] week1 = {f11, f12, f13, b11, b12, b13, s11, s12, s13, c11, c12, c13, bm11, bm12, bm13, bm14, g11, g12, g13, g14};
        lessonManager.addLessons(week1);

        // week 2
        Lesson f21 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(20), LessonCapacity.FOOTBALL);
        Lesson f22 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(21), LessonCapacity.FOOTBALL);
        Lesson f23 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(22), LessonCapacity.FOOTBALL);
        Lesson b21 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(23), LessonCapacity.BASKETBALL);
        Lesson b22 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(24), LessonCapacity.BASKETBALL);
        Lesson b23 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(25), LessonCapacity.BASKETBALL);
        Lesson s21 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(26), LessonCapacity.SWIMMING);
        Lesson s22 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(27), LessonCapacity.SWIMMING);
        Lesson s23 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(28), LessonCapacity.SWIMMING);
        Lesson c21 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(29), LessonCapacity.CRICKET);
        Lesson c22 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(30), LessonCapacity.CRICKET);
        Lesson c23 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(31), LessonCapacity.CRICKET);
        Lesson bm21 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(32), LessonCapacity.BADMINTON);
        Lesson bm22 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(33), LessonCapacity.BADMINTON);
        Lesson bm23 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(34), LessonCapacity.BADMINTON);
        Lesson bm24 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(35), LessonCapacity.BADMINTON);
        Lesson g21 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(36), LessonCapacity.GYMNASTICS);
        Lesson g22 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(37), LessonCapacity.GYMNASTICS);
        Lesson g23 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(38), LessonCapacity.GYMNASTICS);
        Lesson g24 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(39), LessonCapacity.GYMNASTICS);

        Lesson[] week2 = {f21, f22, f23, b21, b22, b23, s21, s22, s23, c21, c22, c23, bm21, bm22, bm23, bm24, g21, g22, g23, g24};
        lessonManager.addLessons(week2);

        // week 3
        Lesson f31 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(40), LessonCapacity.FOOTBALL);
        Lesson f32 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(41), LessonCapacity.FOOTBALL);
        Lesson f33 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(42), LessonCapacity.FOOTBALL);
        Lesson b31 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(43), LessonCapacity.BASKETBALL);
        Lesson b32 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(44), LessonCapacity.BASKETBALL);
        Lesson b33 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(45), LessonCapacity.BASKETBALL);
        Lesson s31 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(46), LessonCapacity.SWIMMING);
        Lesson s32 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(47), LessonCapacity.SWIMMING);
        Lesson s33 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(48), LessonCapacity.SWIMMING);
        Lesson c31 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(49), LessonCapacity.CRICKET);
        Lesson c32 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(50), LessonCapacity.CRICKET);
        Lesson c33 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(51), LessonCapacity.CRICKET);
        Lesson bm31 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(52), LessonCapacity.BADMINTON);
        Lesson bm32 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(53), LessonCapacity.BADMINTON);
        Lesson bm33 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(54), LessonCapacity.BADMINTON);
        Lesson bm34 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(55), LessonCapacity.BADMINTON);
        Lesson g31 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(55), LessonCapacity.GYMNASTICS);
        Lesson g32 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(56), LessonCapacity.GYMNASTICS);
        Lesson g33 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(58), LessonCapacity.GYMNASTICS);
        Lesson g34 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(59), LessonCapacity.GYMNASTICS);

        Lesson[] week3 = {f31, f32, f33, b31, b32, b33, s31, s32, s33, c31, c32, c33, bm31, bm32, bm33, bm34, g31, g32, g33, g34};
        lessonManager.addLessons(week3);

        // week 4
        Lesson f41 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(60), LessonCapacity.FOOTBALL);
        Lesson f42 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(61), LessonCapacity.FOOTBALL);
        Lesson f43 = new Lesson(LessonTypes.FOOTBALL, new Entity("Football pitch"), times.get(62), LessonCapacity.FOOTBALL);
        Lesson b41 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(63), LessonCapacity.BASKETBALL);
        Lesson b42 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(64), LessonCapacity.BASKETBALL);
        Lesson b43 = new Lesson(LessonTypes.BASKETBALL, new Entity("Basketball court"), times.get(65), LessonCapacity.BASKETBALL);
        Lesson s41 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(66), LessonCapacity.SWIMMING);
        Lesson s42 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(67), LessonCapacity.SWIMMING);
        Lesson s43 = new Lesson(LessonTypes.SWIMMING, new Entity("Swimming pool"), times.get(68), LessonCapacity.SWIMMING);
        Lesson c41 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(69), LessonCapacity.CRICKET);
        Lesson c42 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(70), LessonCapacity.CRICKET);
        Lesson c43 = new Lesson(LessonTypes.CRICKET, new Entity("Cricket field"), times.get(71), LessonCapacity.CRICKET);
        Lesson bm41 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(72), LessonCapacity.BADMINTON);
        Lesson bm42 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(73), LessonCapacity.BADMINTON);
        Lesson bm43 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(74), LessonCapacity.BADMINTON);
        Lesson bm44 = new Lesson(LessonTypes.BADMINTON, new Entity("Badminton court"), times.get(75), LessonCapacity.BADMINTON);
        Lesson g41 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(76), LessonCapacity.GYMNASTICS);
        Lesson g42 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(77), LessonCapacity.GYMNASTICS);
        Lesson g43 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(78), LessonCapacity.GYMNASTICS);
        Lesson g44 = new Lesson(LessonTypes.GYMNASTICS, new Entity("Gymnasium"), times.get(79), LessonCapacity.GYMNASTICS);

        Lesson[] week4 = {f41, f42, f43, b41, b42, b43, s41, s42, s43, c41, c42, c43, bm41, bm42, bm43, bm44, g41, g42, g43, g44};
        lessonManager.addLessons(week4);

        // coaches
        coachesManager.addCoach(new Coach("Terry", "1 lane road", "07123456789",
                new String[] {LessonTypes.FOOTBALL},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {f11, f12, f21, f22, f31, f32, f41, f42}));

        coachesManager.addCoach(new Coach("Maria", "2 road avenue", "07987654321",
                new String[] {LessonTypes.SWIMMING, },
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {s11, s12, s13, s21, s22, s23, c31, c32, c33}));

        coachesManager.addCoach(new Coach("Nina", "3 avenue crescent", "07974835932",
                new String[] {LessonTypes.BASKETBALL},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {b11, b12, b13, b21, b22, b23, b31, b32, b33}));

        coachesManager.addCoach(new Coach("Hassan", "4 random road", "07972084520",
                new String[] {LessonTypes.BADMINTON, LessonTypes.FOOTBALL},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {f13, f23, f33, f43, bm11, bm12, bm21, bm22, bm31}));

        coachesManager.addCoach(new Coach("Demi", "5 long lane", "07983649573",
                new String[] {LessonTypes.GYMNASTICS, LessonTypes.SWIMMING},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {s31, s32, s33, s41, s42, s43, g11, g12, g13}));

        coachesManager.addCoach(new Coach("Jeff", "6 road road", "07983634573",
                new String[] {LessonTypes.CRICKET, LessonTypes.BADMINTON},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {c11, c12, c13, c21, c22, c23, bm13, bm14}));

        coachesManager.addCoach(new Coach("Martha", "7 lane avenue", "07983564573",
                new String[] {LessonTypes.CRICKET, LessonTypes.BADMINTON, LessonTypes.BASKETBALL},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {c41, c42, c43, bm32, bm41, bm42, b41, b42, b43}));

        coachesManager.addCoach(new Coach("Jane", "8 that road", "07983567382",
                new String[] {LessonTypes.GYMNASTICS},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {g14, g21, g22, g23, g24, g31, g32, g33, g34}));

        coachesManager.addCoach(new Coach("Addi", "9 last avenue", "079835681930",
                new String[] {LessonTypes.GYMNASTICS, LessonTypes.BADMINTON},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {g41, g42, g43, g44, bm23, bm24, bm33, bm34, bm43, bm44}));

    }

    public static void generateTimePeriods(){
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
            times.add(new TimePeriod(week - 1, days[dayIndex], hours[hourIndex], 00, 60));
            if(hourIndex == hours.length - 1){
                hourIndex = 0;
                dayIndex += 1;
            } else {
                hourIndex +=1;
            }
        }
    }
}
