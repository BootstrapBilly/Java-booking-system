package Data.InjectTestData;

import Backend.Event.Appointment;
import Backend.Lesson.Lesson;
import Backend.User.Coach;
import Backend.User.User;
import Data.Observer.Coaches.CoachesManager;
import Data.Observer.Users.UsersManager;
import Data.Singleton.Coaches;
import Data.Singleton.Users;
import Constants.LessonTypes;

public class GenerateEntities {
    public static void all(){
        UsersManager usersManager = Users.getManager();
        CoachesManager coachesManager = Coaches.getInstance();

        // students
        usersManager.addUser(new User("Billy", false, true, false));
        usersManager.addUser(new User("James", false, true, false));
        usersManager.addUser(new User("Emily", false, true, false));
        usersManager.addUser(new User("Sarah", false, true, false));
        usersManager.addUser(new User("David", false, true, false));

        // admins
        usersManager.addUser(new User("John", true, false, false));
        usersManager.addUser(new User("Jennie", true, false, false));

        // parent
        usersManager.addUser(new User("Parent", false, false, true));

        // coaches
        coachesManager.addCoach(new Coach("Terry", "1 lane road", "07123456789",
                new String[] {LessonTypes.FOOTBALL},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {}));

        coachesManager.addCoach(new Coach("Maria", "2 road avenue", "07987654321",
                new String[] {LessonTypes.SWIMMING, LessonTypes.CRICKET},
                new Appointment[] {}, new Appointment[] {},
                new Lesson[] {}));
    }
}
