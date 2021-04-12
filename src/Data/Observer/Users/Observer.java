package Data.Observer.Users;

import Models.User.User;

import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<User> user);
}
