package Data.Observer.Lesson;

import Models.Lesson.Lesson;

import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<Lesson> lessons);
}
