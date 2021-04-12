package Data.InjectTestData;

import Models.Event.Appointment;
import Models.Lesson.Lesson;
import Models.User.Coach;
import Models.User.User;
import Models.Util.Classes.Entity;
import Models.Util.Classes.TimePeriod;
import Data.Observer.Coaches.CoachesManager;
import Data.Observer.Lesson.LessonManager;
import Data.Observer.Users.UsersManager;
import Data.Singleton.Coaches;
import Data.Singleton.Lessons;
import Data.Singleton.Users;
import Constants.LessonTypes;

import java.util.ArrayList;

public class GenerateEntities {
    private static ArrayList <TimePeriod> times = new ArrayList<>();

    public static void all(){
        UsersManager usersManager = Users.getManager();
        CoachesManager coachesManager = Coaches.getInstance();
        LessonManager lessonManager = Lessons.getInstance();

        // times
        generateTimePeriods();

        // students
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
        Lesson f1 = new Lesson("Football", new Entity("Football pitch"), times.get(0), 15, 0);
        Lesson b1 = new Lesson("Basketball", new Entity("Basketball court"), times.get(9), 15, 0);
        lessonManager.addLesson(f1);
        lessonManager.addLesson(b1);

        // coaches
        coachesManager.addCoach(new Coach("Terry", "1 lane road", "07123456789",
                new String[] {LessonTypes.FOOTBALL},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {f1,b1}));

        coachesManager.addCoach(new Coach("Maria", "2 road avenue", "07987654321",
                new String[] {LessonTypes.SWIMMING, LessonTypes.CRICKET},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {}));

        coachesManager.addCoach(new Coach("Nina", "3 avenue crescent", "07974835932",
                new String[] {LessonTypes.BASKETBALL, LessonTypes.BADMINTON},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {}));

        coachesManager.addCoach(new Coach("Hassan", "4 random road", "07972084520",
                new String[] {LessonTypes.BADMINTON},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {}));

        coachesManager.addCoach(new Coach("Demi", "5 long lane", "07983649573",
                new String[] {LessonTypes.GYMNASTICS},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {}));

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
