package Data.Observer.Coaches;

import Backend.User.Object;

import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<Object> objects);
}
