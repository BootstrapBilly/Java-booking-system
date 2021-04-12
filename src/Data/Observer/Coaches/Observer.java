package Data.Observer.Coaches;

import Models.User.Coach;

import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<Coach> coaches);
}
