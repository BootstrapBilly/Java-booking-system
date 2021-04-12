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

public class GenerateEntities {
    public static void all(){
        UsersManager usersManager = Users.getManager();
        CoachesManager coachesManager = Coaches.getInstance();
        LessonManager lessonManager = Lessons.getInstance();

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

        // times
        TimePeriod week1 = new TimePeriod(1, 2, 18, 0, 60);

        // lessons
        Lesson f1 = new Lesson("Football", new Entity("Football pitch"), week1, 15, 0);
        Lesson b1 = new Lesson("Basketball", new Entity("Basketball court"), week1, 15, 0);
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
}
